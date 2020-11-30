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
public class SavingsAccount extends Account {
    
    private final String ACC_TYPE = "Saving";

    public SavingsAccount() {
        super();
        this.interest = 0.0005;
    }

    public SavingsAccount(String branch, double balance) {
        super(branch, balance);
        this.accType = ACC_TYPE;
        this.interest = 0.0005;
    }

}
