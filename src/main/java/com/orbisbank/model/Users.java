package com.orbisbank.model;

import java.util.Date;

public class Users {

    private int users_id;
    private String users_name;
    private String users_surname;
    private String users_email;
    private String password;
    private Date created_at;

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public String getUsers_name() {
        return users_name;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

    public String getUsers_surname() {
        return users_surname;
    }

    public void setUsers_surname(String users_surname) {
        this.users_surname = users_surname;
    }

    public String getUsers_email() {
        return users_email;
    }

    public void setUsers_email(String users_email) {
        this.users_email = users_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Users{" +
                "users_id=" + users_id +
                ", users_name='" + users_name + '\'' +
                ", users_surname='" + users_surname + '\'' +
                ", users_email='" + users_email + '\'' +
                ", password='" + password + '\'' +
                ", created_at=" + created_at +
                '}';
    }

}
