/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myoopass11;


import javax.swing.*;
//import java.awt.Font;
//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.beans.Statement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.table.DefaultTableModel;
import java.sql.*;



/**
 *
 * @author Josiane Mango
 */
public class Ours2 extends JFrame {
    JLabel fn, ln,g, phone, dob, age, id;
    JTextField txtfname, txtlname,txtgender, txtphone, txtdob, txtage, txtid;
    JButton jadd, update, delete;
     ResultSet rst;
    public Ours2(){
        
     JFrame myframe=new JFrame("SAVE UPDATE DELETE FROM DATABASE ");
     fn=new JLabel("First Name");
     ln=new JLabel("Last Name");
     g=new JLabel("Gender");
     phone=new JLabel("Phone Number");
     dob=new JLabel("Date Of Birth");
     age=new JLabel("Age");
     id=new JLabel("Id");
    
    fn.setBounds(20, 20, 100, 20);
    ln.setBounds(20, 50, 100, 20);
    g.setBounds(20, 80, 100, 20);
    phone.setBounds(20, 110, 100, 20);
    dob.setBounds(20, 140, 100, 20);
    age.setBounds(20, 170, 100, 20);
    id.setBounds(20, 200, 100, 20);
    
    
    
     txtfname= new JTextField(20);// VARCHAR  should contain not more than 25 characters
     txtlname= new JTextField(20);// VARCHAR should contain not more than 25 characters
     txtgender=new JTextField(20);// VARCHAR should contain not more than 6 characters
     txtphone=new JTextField(20);// INT , not more than 10 numbers
     txtdob=new JTextField(20);// DATE,  fprmat : yyyy-mm-dd
     txtage=new JTextField(20);//INT , not more than 2 numbers
     txtid=new JTextField(20);// INT
    
    txtfname.setBounds(130, 20, 150, 20);
    txtlname.setBounds(130, 50, 150, 20);
    txtgender.setBounds(130, 80, 150, 20);
    txtphone.setBounds(130, 110, 150, 20);
    txtdob.setBounds(130, 140, 150, 20);
    txtage.setBounds(130, 170, 150, 20);
    txtid.setBounds(130, 200, 150, 20);
    
    txtfname.setFont(new java.awt.Font("Tahoma", 1, 18));
    txtlname.setFont(new java.awt.Font("Tahoma", 1, 18));
    txtgender.setFont(new java.awt.Font("Tahoma", 1, 18));
    txtphone.setFont(new java.awt.Font("Tahoma", 1, 18));
    txtdob.setFont(new java.awt.Font("Tahoma", 1, 18));
    txtage.setFont(new java.awt.Font("Tahoma", 1, 18));
    txtid.setFont(new java.awt.Font("Tahoma", 1, 18));
    
     jadd=new JButton("Save");
     update=new JButton("Update");
    delete=new JButton("Delete");
    
    jadd.setBounds(300, 50, 80, 20);
    update.setBounds(300, 80, 80, 20);
    delete.setBounds(300, 110, 80, 20);
    
   
    
    
   
    
    myframe.setLayout(null);
    myframe.add(fn);
    myframe.add(ln);
    myframe.add(g);
    myframe.add(phone);
    myframe.add(dob);
    myframe.add(age);
    myframe.add(id);
    myframe.add(txtid);
    myframe.add(txtfname);
    myframe.add(txtlname);
    myframe.add(txtgender);
    myframe.add(txtphone);
    myframe.add(txtdob);
    myframe.add(txtage);
    
    myframe.add(jadd);
    
    
    jadd.addActionListener(new ActionListener (){
       
       
        public void actionPerformed(ActionEvent e){
           try{
         theQuery("insert into user (First_Name,Last_Name, Date_of_Birth,Telephone,Gender,Age,Id)   values ('"+txtfname.getText()+"','"+txtlname.getText()+"','"+txtdob.getText()+"','"+txtphone.getText()+"','"+txtgender.getText()+"',"+txtage.getText()+","+txtid.getText()+")");
           }
      catch(Exception ex){
      }
        }

        
        
            });
   
    
    myframe.add(update);
    
    update.addActionListener(new ActionListener(){
       
        public void actionPerformed(ActionEvent e){
            try{
               theQuery("update user set First_Name ='"+txtfname.getText()+"', Last_Name = '"+txtlname.getText()+"' ,Date_of_Birth = '"+txtdob.getText()+"',Telephone = '"+txtphone.getText()+"',Gender ='"+txtgender.getText()+"' ,Age = "+txtage.getText()+" where Id ="+txtid.getText()); 
            }
             
        
            catch(Exception ex) {}
        }    

        
    });
    
    myframe.add(delete);
    
    delete.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                try{
                    theQuery("delete from user where Id="+txtid.getText());
                }catch(Exception ex){}
                }
                
            });
                
               
    
    
    myframe.setSize(900,400);
    myframe.setLocationRelativeTo(null);
    myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myframe.setVisible(true);
              
        
    }
    
    public void theQuery (String query) {
        Connection con=null;
        Statement st=null;
        try{
            
             con = DriverManager.getConnection("jdbc:mysql://localhost/userdb", "root", "");
             st=con.createStatement();
             st.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Query Executed");
             
             }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
    } public ResultSet chartData(){
        
        String query ="select Gender, Age from user";
        Statement statement;
        try{
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/userdb", "root", "");
             statement=conn.prepareStatement(query);
            rst =  statement.executeQuery(query);
             
        }catch(Exception es){
        
        }
        
        return rst;
    }
    
    

    public static void main(String[] args) {
  
    new Ours2();
    
}
}









