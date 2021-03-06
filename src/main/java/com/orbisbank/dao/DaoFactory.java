package com.orbisbank.dao;

import com.orbisbank.dao.impl.ClientsDaoJdbc;
import com.orbisbank.dao.impl.UsersDaoJdbc;
import com.orbisbank.dao.impl.ContractDaoJdbc;
import java.sql.SQLException;

public class DaoFactory {

    private static UsersDao usersDao;
    private static ClientsDao clientsDao;
    private static ContractDao contractDao;

    private DaoFactory(){
        throw new IllegalStateException();
    }

    public static UsersDao getUsersDao() throws SQLException{

        if(usersDao == null) {
            usersDao = new UsersDaoJdbc();
        }
        return usersDao;
    }

    public static  ClientsDao getClientsDao() throws SQLException{

        if (clientsDao == null) {
            clientsDao = new ClientsDaoJdbc();
        }
        return clientsDao;
    }

    public static ContractDao getContractDao() throws SQLException{

        if (contractDao == null) {
            contractDao = new ContractDaoJdbc();
        }
        return contractDao;
    }

}
