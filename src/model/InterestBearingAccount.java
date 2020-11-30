/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Acer
 */
public class InterestBearingAccount extends Account {
    
    private final String ACC_TYPE = "Interest Bearing";
    
    //private final double INTEREST = 0.05;
    private final double initialDepositAmnt = 500.00;

    public InterestBearingAccount() {
        super();
        this.interest = 0.05;
    }

    public InterestBearingAccount(String branch, double balance) {
        super(branch, balance);
        this.balance = this.initialDepositAmnt;
        this.accType = ACC_TYPE;
        this.interest = 0.05;
    }
    
}
