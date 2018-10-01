/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myoopass11;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Josiane Mango
 */
public class Myconnection {
    Connection con = null;
      public static Connection  Myconnection(){ 
       try{
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost/receptionistdb"; //port to mysql is 3306
            Connection con = DriverManager.getConnection(databaseURL, "root", "");
            //JOptionPane.showMessageDialog(null, "Connected to DB!");
            return con;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    } 
       
        
        
        
    }

        
    

    