package com.javaee.ex10_security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@SpringBootTest
class Ex10SecurityApplicationTests {

    @Test
    void contextLoads() {
        /*Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
        System.out.println(pbkdf2PasswordEncoder.encode("888888"));*/
    }

}
