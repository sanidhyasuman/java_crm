
package maincrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Dlt extends JFrame implements ActionListener {
     JTextField tfcid;

   Dlt(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lbuser=new JLabel("Customer ID");
        lbuser.setBounds(40,20,100,30);
        add(lbuser);
        
        tfcid=new JTextField();
        tfcid.setBounds(150,20,150,30);
        add(tfcid);
        
        
        
        JButton delete=new JButton("Delete");
        delete.setBounds(150,140,150,50);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
   
   }

    @Override
    public void actionPerformed(ActionEvent ae) {
      try{
                String cuid = tfcid.getText();
                Conn conn=new Conn();
                String query="delete from customer where cid='"+cuid+"'";
                int rs = conn.s.executeUpdate(query);
                if (rs > 0) {
                    JOptionPane.showMessageDialog(this, "Record deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "No record found with ID " + cuid + ".");
                }
//                JOptionPane.showMessageDialog(null,"Deleted Successfully");
//                setVisible(false);
//                new Home();
//                
            }catch(Exception e){
                e.printStackTrace();
            }
    }  
         public static void main(String args[])
    {
        new Dlt();
    }
}
        

