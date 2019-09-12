package com.youyuan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zhangyu
 * @version 1.0
 * @description
 * @date 2019/4/9 16:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class EmployeeTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void jdbcTest() throws SQLException {
        DataSource dataSource=applicationContext.getBean(DataSource.class);
        Connection connection=dataSource.getConnection();
        System.out.println("applicationContext:"+applicationContext);
        System.out.println("dataSource:"+dataSource);
        System.out.println("connection:"+connection);
    }
}
