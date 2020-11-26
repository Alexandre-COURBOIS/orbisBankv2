package com.orbisbank.dao.impl;

import com.orbisbank.dao.ClientsDao;
import com.orbisbank.dao.ContractDao;
import com.orbisbank.model.Clients;
import com.orbisbank.model.Contract;
import com.orbisbank.model.Users;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContractDaoJdbc extends JdbcDao implements ContractDao {

    public ContractDaoJdbc() throws SQLException {
        super();
    }

    @Override
    public void createContract(Contract contract) {

        String sql = "INSERT INTO public.contract (client_id, contract, created_at)" +
                "VALUES (?, ?, ?)";

        try {

            PreparedStatement pstmt = getConnection().prepareStatement(sql);

            pstmt.setInt(1, contract.getClient_id());
            pstmt.setString(2, contract.getContract());
            pstmt.setDate(3, (Date) contract.getCreated_at());

            if (pstmt.executeUpdate() == 1) {
                System.out.println("Contract created");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Contract> getAllContract() {

        ArrayList<Contract> contracts = new ArrayList<>();

        try {

            String sql = "SELECT * FROM public.contract";

            PreparedStatement pstmt = getConnection().prepareCall(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                contracts.add(transformSqlToSqlContract(rs));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contracts;

    }

    @Override
    public Contract getContractByClientId(int clientsId) {

        Contract contract = new Contract();

        try {

            String sql = "SELECT * FROM public.contract WHERE client_id = ?";

            PreparedStatement pstmt = getConnection().prepareCall(sql);

            pstmt.setInt(1, clientsId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                contract = transformSqlToSqlContract(rs);

            } else {

                System.out.println("clients does not exist");

            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }
        return contract;
    }


    private Contract transformSqlToSqlContract(ResultSet rs) throws SQLException {

        Contract contract = new Contract();

        contract.setContract_id(rs.getInt("Id"));
        contract.setClient_id(rs.getInt("Client_id"));
        contract.setContract(rs.getString("Contract"));
        contract.setCreated_at(rs.getDate("created_at"));
        contract.setUpdated_at(rs.getDate("updated_at"));

        return contract;
    }


}
