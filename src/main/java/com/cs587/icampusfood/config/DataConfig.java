/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.config;

import com.mchange.v2.c3p0.C3P0ProxyConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.postgresql.PGConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 *
 * @author Joey
 */
@Configuration
@MapperScan("com.cs587.icampusfood.persistence")
public class DataConfig {
    private final String host = "aahrg5vhtj4ja7.cvrzbbd6lsip.us-west-2.rds.amazonaws.com";
    private final String username = "csci587project";
    private final String password = "iCampusFood587";
    private final String dbName = "main";
    private final int port = 5432;
    @Bean
    public DataSource dataSource() {
        //Connection con=null;
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            //dataSource.setDriverClassName("org.postgresql.Driver"); //loads the jdbc driver


            dataSource.setDriverClass("org.postgis.DriverWrapper");
        } catch (PropertyVetoException ex) {
            //Logger.getLogger(DataConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        //dataSource.setJdbcUrl("jdbc:postgresql://" + host + ":" + port + "/" + dbName + "?autoReconnect=true");
        dataSource.setJdbcUrl("jdbc:postgresql_postGIS://" + host + ":" + port + "/" + dbName + "?autoReconnect=true");
        dataSource.setUser(username);
        dataSource.setPassword(password);
        //need to add geometry data types to connections
        /*
        try{
            con = dataSource.getConnection();
            //Add the PostGIS geometry types to the connection
            ((org.postgresql.PGConnection) con).addDataType("geometry",org.postgis.PGgeometry.class);

        }catch (Exception e) {
            e.printStackTrace();
        }*/
        /*DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://" + host + ":" + port + "/"+ dbName + "?autoReconnect=true");
        dataSource.setUsername(username);
        dataSource.setPassword(password);*/


        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("com.cs587.icampusfood.domain");
        sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return sessionFactory;
    }
}