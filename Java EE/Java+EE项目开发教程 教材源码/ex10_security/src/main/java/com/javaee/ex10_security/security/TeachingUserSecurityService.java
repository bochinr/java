package com.javaee.ex10_security.security;

import com.javaee.ex10_security.mapper.UserMapper;
import com.javaee.ex10_security.po.Role;
import com.javaee.ex10_security.po.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeachingUserSecurityService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        SysUser user = userMapper.findUserByLoginName(username);
        if (user == null)
            throw new UsernameNotFoundException("登录名不存在");
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = user.getRoleList();
        for (Role role : roles){
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
            authorities.add(authority);
        }
        User securityUser = new User(user.getLoginName(),user.getPassword(), authorities);
        return securityUser;
    }
}
