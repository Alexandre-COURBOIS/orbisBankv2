package com.orbisbank.dao;

import com.orbisbank.model.Contract;

import java.util.ArrayList;

public interface ContractDao {

    public void createContract(Contract contract);
    public ArrayList<Contract> getAllContract();
    public ArrayList<Contract> getContractByClientId(int clientId);

}
