package com.javaee.ex08.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@ComponentScan(value = "com.javaee.ex08.service")
@PropertySource("classpath:config/db.properties")
@EnableTransactionManagement    // 开启声明式事务管理的支持
public class DataSourceConfig {
    @Value("${mysql.driver}")
    private String driver;
    @Value("${mysql.url}")
    private String url;
    @Value("${mysql.username}")
    private String userName;
    @Value("${mysql.password}")
    private String password;
    @Bean("dataSource")
    public DataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(
            @Autowired DataSource dataSource){
        DataSourceTransactionManager dstManager = new DataSourceTransactionManager();
        dstManager.setDataSource(dataSource);
        return dstManager;
    }
}
