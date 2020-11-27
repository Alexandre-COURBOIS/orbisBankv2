package com.orbisbank.dao.impl;

import com.orbisbank.dao.UsersDao;
import com.orbisbank.model.Users;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersDaoJdbc extends JdbcDao implements UsersDao {

    public UsersDaoJdbc() throws SQLException {
        super();
    }

    @Override
    public void createUsers(Users users) {

        String sql = "INSERT INTO public.users (name, surname, email, password, created_at, role)" +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement pstmt = getConnection().prepareStatement(sql);

            pstmt.setString(1, users.getUsers_name());
            pstmt.setString(2, users.getUsers_surname());
            pstmt.setString(3, users.getUsers_email());
            pstmt.setString(4, users.getPassword());
            pstmt.setDate(5, (Date) users.getCreated_at());
            pstmt.setString(6, users.getRole());

            /*pstmt.executeUpdate();*/

            if (pstmt.executeUpdate() == 1) {
                System.out.println("User has been created");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Users users) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE public.users SET name  = ?, surname = ?, email = ?, updated_at = ? WHERE id = ?");
            stmt.setString(1, users.getUsers_name());
            stmt.setString(2, users.getUsers_surname());
            stmt.setString(3, users.getUsers_email());
            stmt.setDate(4, (Date) users.getUpdated_at());
            stmt.setInt(5, users.getUsers_id());

            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updatePassword(Users users) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE public.users SET password  = ?, updated_at = ? WHERE id = ?");
            stmt.setString(1, users.getPassword());
            stmt.setDate(2, (Date) users.getUpdated_at());
            stmt.setInt(3, users.getUsers_id());

            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ArrayList<Users> getAllUsers() {

        ArrayList<Users> users = new ArrayList<>();

        try {

            String sql = "SELECT * FROM public.users";

            PreparedStatement pstmt = getConnection().prepareCall(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                users.add(transformSqlToUsers(rs));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public ArrayList<Users> getAllUsersByRole(String role) {

        ArrayList<Users> users = new ArrayList<>();

        try {

            String sql = "SELECT * FROM public.users WHERE role = ?";

            PreparedStatement pstmt = getConnection().prepareCall(sql);

            pstmt.setString(1, role);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                users.add(transformSqlToUsers(rs));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Users getUsersById(int usersId) {

        Users user = new Users();

        try {

            String sql = "SELECT * FROM public.users WHERE id = ?";

            PreparedStatement pstmt = getConnection().prepareCall(sql);

            pstmt.setInt(1, usersId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                user = transformSqlToUsers(rs);

            } else {

                System.out.println("user does not exist");

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }
        return user;
    }

    @Override
    public Users getUsersByEmail(String usersEmail) {

        Users users = new Users();

        try {

            String sql = "SELECT * FROM public.users WHERE email = ?";
            PreparedStatement pstmt = getConnection().prepareCall(sql);
            pstmt.setString(1, usersEmail);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                users = transformSqlToUsers(rs);
            } else {
                System.out.println("user does not exist");
            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return users;
    }

    @Override
    public boolean deleteUsersById(int usersId) {

        try {

            String sql = "DELETE FROM public.users WHERE id = ?";

            PreparedStatement pstmt = getConnection().prepareStatement(sql);

            pstmt.setInt(1, usersId);

            pstmt.executeUpdate();

            return false;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    private Users transformSqlToUsers(ResultSet rs) throws SQLException {

        Users users = new Users();

        users.setUsers_id(rs.getInt("id"));
        users.setUsers_name(rs.getString("name"));
        users.setUsers_surname(rs.getString("surname"));
        users.setUsers_email(rs.getString("email"));
        users.setPassword(rs.getString("password"));
        users.setCreated_at(rs.getDate("created_at"));
        users.setRole(rs.getString("role"));

        return users;
    }


}
