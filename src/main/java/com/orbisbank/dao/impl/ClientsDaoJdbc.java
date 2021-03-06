package com.orbisbank.dao.impl;

import com.orbisbank.dao.ClientsDao;
import com.orbisbank.model.Clients;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientsDaoJdbc extends JdbcDao implements ClientsDao {

    public ClientsDaoJdbc() throws  SQLException {
        super();
    }


    @Override
    public void createClients(Clients clients) {
        String sql = "INSERT INTO public.clients (surname, name, email, phone, age, income, owner, postalcode, address, city, created_at)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement pstmt = getConnection().prepareStatement(sql);

            pstmt.setString(1, clients.getSurname());
            pstmt.setString(2, clients.getName());
            pstmt.setString(3, clients.getEmail());
            pstmt.setString(4, clients.getPhone());
            pstmt.setInt(5,clients.getAge());
            pstmt.setInt(6,clients.getIncome());
            pstmt.setBoolean(7,clients.isOwner());
            pstmt.setInt(8, clients.getPostalCode());
            pstmt.setString(9, clients.getAddress());
            pstmt.setString(10, clients.getCity());
            pstmt.setDate(11, (Date) clients.getCreated_at());

            /*pstmt.executeUpdate();*/

            if (pstmt.executeUpdate() == 1) {
                System.out.println("Clients has been created");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Clients> getAllClients() {

        ArrayList<Clients> clients = new ArrayList<>();

        try {

            String sql = "SELECT * FROM public.clients";

            PreparedStatement pstmt = getConnection().prepareCall(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                clients.add(transformSqlToClients(rs));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;

    }

    @Override
    public Clients getClientsById(int clientsId) {

        Clients clients = new Clients();

        try {

            String sql = "SELECT * FROM public.clients WHERE id = ?";

            PreparedStatement pstmt = getConnection().prepareCall(sql);

            pstmt.setInt(1, clientsId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                clients = transformSqlToClients(rs);

            } else {

                System.out.println("clients does not exist");

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }
        return clients;
    }

    @Override
    public Clients getClientsByEmail(String clientsEmail) {

        Clients clients = new Clients();

        try {

            String sql = "SELECT * FROM public.clients WHERE email = ?";

            PreparedStatement pstmt = getConnection().prepareCall(sql);

            pstmt.setString(1, clientsEmail);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                clients = transformSqlToClients(rs);

            } else {

                System.out.println("clients does not exist");

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }
        return clients;
    }

    @Override
    public boolean deleteClientsById(int clientsId) {

        try {

            String sql = "DELETE FROM public.clients WHERE id = ?";

            PreparedStatement pstmt = getConnection().prepareStatement(sql);

            pstmt.setInt(1, clientsId);

            pstmt.executeUpdate();

            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    private Clients transformSqlToClients(ResultSet rs) throws SQLException {

        Clients clients = new Clients();

        clients.setClientsId(rs.getInt("id"));
        clients.setSurname(rs.getString("surname"));
        clients.setName(rs.getString("name"));
        clients.setEmail(rs.getString("email"));
        clients.setPhone(rs.getString("phone"));
        clients.setAge(rs.getInt("age"));
        clients.setIncome(rs.getInt("income"));
        clients.setOwner(rs.getBoolean("owner"));
        clients.setPostalCode(rs.getInt("postalcode"));
        clients.setAddress(rs.getString("address"));
        clients.setCity(rs.getString("city"));
        clients.setCreated_at(rs.getDate("created_at"));
        clients.setUpdated_at(rs.getDate("updated_at"));

        return clients;
    }
}
