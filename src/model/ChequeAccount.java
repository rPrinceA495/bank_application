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
public class ChequeAccount extends Account {
    
    private final String ACC_TYPE = "Cheque";

    public ChequeAccount() {
        super();
        this.interest = 0;
    }

    public ChequeAccount(String branch, double balance) {
        super(branch, balance);
        
        this.accType = ACC_TYPE;
        this.interest = 0;
    }
    
    
}
