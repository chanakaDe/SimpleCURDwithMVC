/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.model;

/**
 *
 * @author ChanakaDeSilva
 */
public class Policy {
    private String policyNo;
    private String type;
    private String date;
    private String amount;
    private String customer;

    public Policy() {
    }

    public Policy(String policyNo, String type, String date, String amount, String customer) {
        this.policyNo = policyNo;
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.customer = customer;
    }

    /**
     * @return the policyNo
     */
    public String getPolicyNo() {
        return policyNo;
    }

    /**
     * @param policyNo the policyNo to set
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the customer
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    
   
    
}
