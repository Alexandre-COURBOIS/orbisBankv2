package com.orbisbank.model;

public class Contract {

    private int contract_id;
    private int client_id;
    private String contract;

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contract_id=" + contract_id +
                ", client_id=" + client_id +
                ", contract='" + contract + '\'' +
                '}';
    }
}
