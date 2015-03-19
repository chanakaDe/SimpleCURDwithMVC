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
public class Claim {
    private String id;
    private String policyID;
    private String customer;
    private String amount;

    public Claim() {
    }

    public Claim(String id, String policyID, String customer, String amount) {
        this.id = id;
        this.policyID = policyID;
        this.customer = customer;
        this.amount = amount;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the policyID
     */
    public String getPolicyID() {
        return policyID;
    }

    /**
     * @param policyID the policyID to set
     */
    public void setPolicyID(String policyID) {
        this.policyID = policyID;
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
    
    
}
