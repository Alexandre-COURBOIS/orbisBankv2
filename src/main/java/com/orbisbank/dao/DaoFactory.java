package com.orbisbank.dao;

import com.orbisbank.dao.impl.UsersDaoJdbc;
import java.sql.SQLException;

public class DaoFactory {

    private static UsersDao usersDao;

    private DaoFactory(){
        throw new IllegalStateException();
    }

    public static UsersDao getUsersDao() throws SQLException{

        if(usersDao == null) {
            usersDao = new UsersDaoJdbc();
        }
        return usersDao;
    }

}
