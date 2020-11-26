package com.orbisbank.model;

import java.util.Date;

public class Contract {

    private int contract_id;
    private int client_id;
    private String contract;
    private Date created_at;
    private Date updated_at;


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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contract_id=" + contract_id +
                ", client_id=" + client_id +
                ", contract='" + contract + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }

}
