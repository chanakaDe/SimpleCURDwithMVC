/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.controller;

import insurance.db.DBConnection;
import insurance.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ChanakaDe
 */
public class UserController {

    public static int addUser(User user) throws ClassNotFoundException, SQLException {
        String sql = "insert into User values(?,password(?),?,?)";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setString(1, user.getUsername());
        pStatement.setString(2, user.getPassword());
        return pStatement.executeUpdate();
    }

    public static int getPrivileges(String username, String pasword) throws ClassNotFoundException, SQLException {
        String sql = "select username from user where username=? and password=password(?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pStatement = conn.prepareStatement(sql);
        pStatement.setString(1, username);
        pStatement.setString(2, pasword);
        ResultSet rst = pStatement.executeQuery();
        if (rst.next()) {
            return rst.getInt(1);
        } else {
            return -1;
        }
    }

    public static User[] viewUsers() throws ClassNotFoundException, SQLException {
        String sql = "select * from user";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        User[] users = new User[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String userName = rst.getString("UserName");
            String password = rst.getString("Password");
            User user = new User("", userName, password);
            users[i] = user;
        }
        return users;
    }

    public static int getPrivilegesfromName(String username) throws ClassNotFoundException, SQLException {
        String sql = "select Privilege from user where username=?";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pStatement = conn.prepareStatement(sql);
        pStatement.setString(1, username);
        ResultSet rst = pStatement.executeQuery();
        if (rst.next()) {
            return rst.getInt(1);
        } else {
            return -1;
        }
    }

    public static String getPassword(String username) throws ClassNotFoundException, SQLException {
        String sql = "select password from user where username=? ";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pStatement = conn.prepareStatement(sql);
        pStatement.setString(1, username);
        ResultSet rst = pStatement.executeQuery();
        if (rst.next()) {
            return rst.getString("Password");
        } else {
            return null;
        }
    }

    public static int updateUser(String pwd, String useName) throws ClassNotFoundException, SQLException {
        String sql = "update user set Password=password(?) where Username=?";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, pwd);
        stm.setString(2, useName);
        int res = stm.executeUpdate();
        return res;
    }

    public static int deleteUser(String userName) throws ClassNotFoundException, SQLException {
        String sql = "delete from user where UserName = ?";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pStatement = conn.prepareStatement(sql);
        pStatement.setString(1, userName);
        int executeUpdate = pStatement.executeUpdate();
        return executeUpdate;
    }

    public static String getEmail(String username) throws ClassNotFoundException, SQLException {
        String sql = "select email from user where username=? ";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pStatement = conn.prepareStatement(sql);
        pStatement.setString(1, username);
        ResultSet rst = pStatement.executeQuery();
        if (rst.next()) {
            return rst.getString("email");
        } else {
            return null;
        }
    }
}
