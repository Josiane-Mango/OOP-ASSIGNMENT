/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myoopass11;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import myoopass11.Ours2;

/**
 *
 * @author Josiane Mango
 */
public class Trytry1 {

    /**
     * @param args the command line arguments
     */
   public Trytry1(){
       gui2();
   }
   public void gui2(){
   
   
       Connection con = null;
        Statement st = null;
        ResultSet rs=null;
        String s;
        try{
        con= DriverManager.getConnection("jdbc:mysql://localhost/userdb", "root", "");
        st = con.createStatement();
        s ="select * from user";
        rs = st.executeQuery(s);
        ResultSetMetaData rsmt = rs.getMetaData();
        int c = rsmt.getColumnCount ();
        Vector column = new Vector(c);
        for (int i=1; i<=c; i++)
        {
           column.add(rsmt.getColumnName(i)); 
        }
        Vector data = new Vector();
        Vector row= new Vector();
        while(rs.next())
        {
            row = new Vector(c);
            for(int i = 1; i <= c; i++){
                row.add(rs.getString(i));
            }
            data.add(row);
        }
        
        
        JFrame myframe= new JFrame ("Table from Database");
        myframe.setSize(900,600);
        myframe.setLocationRelativeTo(null);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        
        
        
        
        JPanel mypanel = new JPanel();
        
        
        JTable mytable = new JTable(data, column);
       
        
        
        JScrollPane jsp = new JScrollPane(mytable);
        
        mypanel.setLayout(new BorderLayout());
        mypanel.add(jsp, BorderLayout.CENTER);
        
        
        myframe.setContentPane(mypanel);
        myframe.setVisible(true);
        
        
        
        
        
        
    }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR");
            
        }finally{
            try {
                st.close();
                rs.close();
                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"ERROR ");
            }
            
           
                
            }
        JFrame frame=new JFrame();
        JPanel panel= new JPanel();
        JButton adduser= new JButton("ADD USER");
        JButton logout= new JButton("LOGOUT");
        JButton showchart=new JButton ("SHOW CHARTS");
        panel.add(adduser);
        panel.add(logout);
        panel.add(showchart);
       
        frame.add(panel);
        frame.setSize(900,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
       
        
        adduser.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                try{
                   Ours2 Info=new Ours2 ();
                   Info.setVisible(true);
                   Info.pack();
                   Info.setLocationRelativeTo(null);
                   
                    
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Login Failed! \nPlease check your credentials", "Access Denied", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        logout.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent ex){
                System.exit(0);
            }
            
        });
        
        
         
        }
    public static void main(String[] args) {

 new Trytry1 ();
    } 
}



    
    

