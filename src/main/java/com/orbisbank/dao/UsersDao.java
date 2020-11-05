package com.orbisbank.dao;

import com.orbisbank.model.Users;

public interface UsersDao {

    public void createUsers(Users users);
    public Users getUsersById(int usersId);
    public Users getUsersByEmail(String usersEmail);

}
