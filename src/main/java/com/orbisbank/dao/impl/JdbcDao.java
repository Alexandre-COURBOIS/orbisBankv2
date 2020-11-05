package com.orbisbank.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcDao {

    private static final String URL="jdbc:postgresql://127.0.0.1/orbisbank";
    private static final String USER="postgres";
    private static final String PASS="root";

    private final Connection connection;

    public JdbcDao() throws SQLException{
        this.connection = DriverManager.getConnection(URL, USER, PASS);
        System.out.println("connected to database");
        //postgre this.connection = DriverManager.getConnection("jdbc:postgresql://hostname:port/dbname", "root", "root");
    }

    protected Connection getConnection(){
        return this.connection;
    }
}
