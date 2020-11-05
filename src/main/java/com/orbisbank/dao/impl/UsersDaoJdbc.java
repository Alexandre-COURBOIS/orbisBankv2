package com.orbisbank.dao.impl;

import com.orbisbank.dao.UsersDao;
import com.orbisbank.model.Users;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersDaoJdbc extends JdbcDao implements UsersDao {

    public UsersDaoJdbc() throws SQLException {
        super();
    }

    @Override
    public void createUsers(Users users) {

        String sql = "INSERT INTO public.users (name, surname, email, password, created_at)" +
                "VALUES (?, ?, ?, ?, ?)";

        try {

            PreparedStatement pstmt = getConnection().prepareStatement(sql);

            pstmt.setString(1, users.getUsers_name());
            pstmt.setString(2, users.getUsers_surname());
            pstmt.setString(3, users.getUsers_email());
            pstmt.setString(4, users.getPassword());
            pstmt.setDate(5, (Date) users.getCreated_at());

            pstmt.executeUpdate();

            if (pstmt.executeUpdate() == 1) {
                System.out.println("User has been created");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
