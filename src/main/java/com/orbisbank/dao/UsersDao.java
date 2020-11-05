package com.orbisbank.dao;

import com.orbisbank.model.Users;

import java.util.ArrayList;

public interface UsersDao {

    public void createUsers(Users users);
    public ArrayList<Users> getAllUsers();
    public Users getUsersById(int usersId);
    public Users getUsersByEmail(String usersEmail);
    public boolean deleteUsersById(int id);

}
