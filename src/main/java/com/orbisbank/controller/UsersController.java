package com.orbisbank.controller;

import com.orbisbank.dao.DaoFactory;
import com.orbisbank.dao.UsersDao;
import com.orbisbank.dao.impl.SecurityDao;
import com.orbisbank.dao.impl.UsersDaoJdbc;
import com.orbisbank.model.Users;
import sun.misc.Launcher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersController {

    private Users users;


    public void newUsers() throws SQLException {
        DaoFactory.getUsersDao().createUsers(users);
    }


    public static void setUsers(String name, String surname, String email, String password) throws SQLException {

        Users user = new Users();
        SecurityDao security = new SecurityDao();

        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());

        user.setUsers_name(name);
        user.setUsers_surname(surname);
        user.setUsers_email(email);
        user.setPassword(security.hashPassword(password));
        user.setCreated_at(date_sql);

        DaoFactory.getUsersDao().createUsers(user);

    }

    public static void getAllusers() throws SQLException {
        ArrayList<Users> users = DaoFactory.getUsersDao().getAllUsers();
        users.forEach(System.out::println);
    }

    public static void getUserById (int id) throws SQLException {
        System.out.println(DaoFactory.getUsersDao().getUsersById(id));
    }

    public static  void getUserByEmail (String email) throws SQLException {
        System.out.println(DaoFactory.getUsersDao().getUsersByEmail(email));
    }

    public static void deleteUserById (int usersId) throws SQLException {
        System.out.println(DaoFactory.getUsersDao().deleteUsersById(usersId));
    }






}
