package com.example.model;


import lombok.Getter;

/**
 * Created by sriharshakota on 8/22/17.
 */

@Getter
public class Account {
    private int id;
    private String fName;
    private  String lName;
    private double balance;

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setbalance(double balance) {
        this.balance = balance;
    }
    public void setid(int id) {
        this.id = id;
    }

    public int getid() {
        return id;
    }
}

