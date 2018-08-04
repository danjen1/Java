/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.payroll;
import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author DilinieSeimon
 */
public class db {
    public static Connection java_db() {
    try{
        Class.forName("org.sqlite.JDBC");
        Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Acer\\Documents\\GIT-Repositories\\Employee-Payroll-Management-System-master\\employeesystem.sqlite");
        return conn;
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        return null;
    }
}
}
