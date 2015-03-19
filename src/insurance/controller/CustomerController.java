/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.controller;

/**
 *
 * @author ChanakaDeSilva
 */
import insurance.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import insurance.model.Customer;

public class CustomerController {

    public static int addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        String sql = "insert into Customer values(?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement prepareStatement = conn.prepareStatement(sql);
        prepareStatement.setString(1, customer.getId());
        prepareStatement.setString(2, customer.getName());
        prepareStatement.setString(3, customer.getAddress());
        prepareStatement.setString(4, customer.getDob());
        prepareStatement.setString(5, customer.getContact());
        int res = prepareStatement.executeUpdate();
        return res;
    }

    public static String getLastId() throws ClassNotFoundException, SQLException {
        String sql = "select id from customer order by 1 desc limit 1";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    public static Customer[] viewCustomer() throws ClassNotFoundException, SQLException {
        String sql = "select * from customer";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Customer[] customerList = new Customer[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String custID = rst.getString("id");
            String name = rst.getString("name");
            String address = rst.getString("address");
            String telNo = rst.getString("dob");
            String nic = rst.getString("contact");

            Customer customer = new Customer(custID, name, address, telNo, nic);

            customerList[i] = customer;
        }
        return customerList;
    }

    public static Customer searchCustomer(String id) throws ClassNotFoundException, SQLException {
        String sql = "select * from customer where id='" + id + "'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        Customer customer = null;
        if (rst.next()) {
            String custID = rst.getString("id");
            String name = rst.getString("name");
            String address = rst.getString("address");
            String telNo = rst.getString("dob");
            String nic = rst.getString("contact");

            customer = new Customer(custID, name, address, telNo, nic);
        }
        return customer;
    }

    public static int deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from customer where CustID=?";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, id);
        int res = preparedStatement.executeUpdate();
        return res;
    }
}
