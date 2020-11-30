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
public class Customer extends User {
    
    private int customerId;
    private String atmPin, companyName, companyAddress;

    public Customer() {
    }

    public Customer(String fName, String lName, String address, String atmPin, String companyName, String companyAddress) {
        super(fName, lName, address);
        this.atmPin = atmPin;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }


    public String getAtmPin() {
        return atmPin;
    }

    public void setAtmPin(String atmPin) {
        this.atmPin = atmPin;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    
}
