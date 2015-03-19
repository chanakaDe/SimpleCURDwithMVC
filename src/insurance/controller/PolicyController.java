/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.controller;

import insurance.db.DBConnection;
import insurance.model.Claim;
import insurance.model.Policy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ChanakaDeSilva
 */
public class PolicyController {

    public static int addPolicy(Policy policy) throws ClassNotFoundException, SQLException {
        
        String sql = "insert into Policy values(?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement prepareStatement = conn.prepareStatement(sql);
        prepareStatement.setString(1, policy.getPolicyNo());
        prepareStatement.setString(2, policy.getType());
        prepareStatement.setString(3, policy.getDate());
        prepareStatement.setString(4, policy.getAmount());
        prepareStatement.setString(5, policy.getCustomer());
        int res = prepareStatement.executeUpdate();
        return res;
    }

    public static String getLastId() throws ClassNotFoundException, SQLException {
        String sql = "select id from policy order by 1 desc limit 1";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    public static Policy searchPolicy(String id) throws ClassNotFoundException, SQLException {
        String sql = "select * from policy where id='" + id + "'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        Policy policy = null;
        if (rst.next()) {
            String id1 = rst.getString("id");
            String type = rst.getString("type");
            String date = rst.getString("date");
            String amount = rst.getString("amount");
            String customer = rst.getString("customer");

            policy = new Policy(id1, type, date, amount, customer);

        }
        return policy;
    }

    public static int addClaim(Claim claim) throws ClassNotFoundException, SQLException {
        String sql = "insert into claimed values(?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement prepareStatement = conn.prepareStatement(sql);
        prepareStatement.setString(1, claim.getId());
        prepareStatement.setString(2, claim.getPolicyID());
        prepareStatement.setString(3, claim.getCustomer());
        prepareStatement.setString(4, claim.getAmount());
        int res = prepareStatement.executeUpdate();
        return res;
    }

    public static Claim[] ViewClaimes() throws ClassNotFoundException, SQLException {
        String sql = "select * from claimed";;
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Claim[] customerList = new Claim[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String id = rst.getString("id");
            String policyID = rst.getString("policyid");
            String customer = rst.getString("customer");
            String amount = rst.getString("amount");

            Claim claim = new Claim(id, policyID, customer, amount);

            customerList[i] = claim;
        }
        return customerList;
    }
}
