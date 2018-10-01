/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myoopass11;

import java.awt.Dimension;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import myoopass11.Trytry1;

/**
 *
 * @author Josiane Mango
 */
public class Myoopass11 {
    
    private JFrame myframe;
    private JPanel mypanel;
    private JLabel username;
    private JLabel password;
    private JPasswordField txtpassword;
    private JTextField txtusername;
    private JButton clear;
    private JButton exit;
    private JButton login;
    Connection con=null;
    
    
    
    
    public Myoopass11(){
        
        Gui();
    }
    public void Gui(){
        
        con= Myconnection.Myconnection();
                
        myframe=new JFrame("Login Form");
        myframe.setVisible(true);
        myframe.setSize(600, 400);
        myframe.setFont(new java.awt.Font("Tahoma", 1, 18));
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mypanel=new JPanel(new GridBagLayout());
        mypanel.setSize(600,400);
     
        
        
        username=new JLabel("Username : ");
        username.setFont(new java.awt.Font("Tahoma", 1, 18));
        txtusername=new JTextField();
        txtusername.setFont(new java.awt.Font("Tahoma", 1, 18));
        txtusername.setColumns(25);
        
        password=new JLabel("Password : ");
        password.setFont(new java.awt.Font("Tahoma", 1, 18));
        
        txtpassword= new JPasswordField();
        txtpassword.setFont(new java.awt.Font("Tahoma", 1, 18));
        txtpassword.setColumns(25);
        
        clear=new JButton("CLEAR");
        clear.setFont(new java.awt.Font("Tahoma", 1, 18));
        clear.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                txtusername.setText(null);
                txtpassword.setText(null);
                
                
            }
            
        });
        
        exit=new JButton("EXIT");
        exit.setFont(new java.awt.Font("Tahoma", 1, 18));
        exit.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
               System.exit(0);
            }
            
        });
        
        login=new JButton("LOGIN");
        login.setFont(new java.awt.Font("Tahoma", 1, 18));
        login.addActionListener(new ActionListener (){
        
            public void actionPerformed(ActionEvent e){
        
               con  = Myconnection.Myconnection();
                PreparedStatement ps;
           
            try {
                
                ps = con.prepareStatement("SELECT * FROM receptionist WHERE Username = ? AND Password= ? ");//,receptionist' is a table in my database "receptionistdb" from mysql:the link to access it is http://localhost/phpmyadmin/db_structure.php?server=1&db=receptionistdb
                // if can not access, you can try these usernames and passwords: 1.username:JOJO  password: two; 2. username: Ariane password : Ari2018#; 3.username: Samuel password : S123; 
                ps.setString(1, txtusername.getText());
                
                ps.setString(2, String.valueOf(txtpassword.getPassword()));
                
                ResultSet rs = ps.executeQuery();
  if(rs.next())
                {
                   // "Trutry1 is the class that contains the information that are already registered in the database "userdb" table "user"; link : http://localhost/phpmyadmin/db_structure.php?server=1&db=userdb
                   Trytry1 rt = new Trytry1();
                                     
                           
            
                }else{
                   JOptionPane.showMessageDialog(null, "Login Failed! \nPlease check your credentials", "Access Denied", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Myoopass11.class.getName()).log(Level.SEVERE, null, ex);
            }              
                
                
                
            }

           
         });
        
        
        
        GridBagConstraints c= new GridBagConstraints();
        
       
        mypanel.add(username);
        mypanel.add(txtusername);
        c.insets=new Insets (10,10,10,10);
        c.gridx=0;
        c.gridy=1;
        mypanel.add(password,c);
        c.gridx=1;
        c.gridy=1;
        mypanel.add(txtpassword,c);
        c.insets=new Insets (4,4,4,4);
        c.gridx=0;
        c.gridy=2;
        mypanel.add(clear,c);
        
        c.gridx=1;
        c.gridy=2;
        mypanel.add(exit,c);
        
        c.gridx=2;
        c.gridy=2;
        mypanel.add(login,c);
        
        myframe.add(mypanel);
        
        
    }   
    
    public static void main(String[] args) {
        
       new Myoopass11 ();
    }
}
    

