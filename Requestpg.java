
package maincrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Requestpg extends JFrame implements ActionListener {
     JButton feedback, complaint, status, back;

   Requestpg(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         JLabel heading=new JLabel("Customer Requests");
        heading.setBounds(220,5,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading); 
        
       feedback=new JButton("FEEDBACK");
        feedback.setBounds(100,130,170,50);
        feedback.setBackground(Color.BLACK);
        feedback.setForeground(Color.WHITE);
        feedback.addActionListener(this);
        add(feedback);
       
         complaint=new JButton("COMPLAINT");
        complaint.setBounds(290,130,170,50);
        complaint.setBackground(Color.BLACK);
        complaint.setForeground(Color.WHITE);
        complaint.addActionListener(this);
        add(complaint);
        
        status=new JButton("COMPLAINT STATUS");
        status.setBounds(480,130,170,50);
        status.setBackground(Color.BLACK);
        status.setForeground(Color.WHITE);
       status.addActionListener(this);
        add(status);
        
         back=new JButton("Back");
        back.setBounds(250,300,150,40 );
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(700,400);
        setLocation(450,200);
        setVisible(true);

   }

    @Override
    public void actionPerformed(ActionEvent ae) {
      try{
           if(ae.getSource() == feedback)
       {
           setVisible(false);
           new Cu_feedback();
       }
       else if(ae.getSource()== complaint)
       {
            setVisible(false);
           new Complaint();
       }
       else if(ae.getSource()== status)
       {
            setVisible(false);
           new Cmp_status();
       }
           else if(ae.getSource()== back)
       {
            setVisible(false);
           new Splash();
       }
               
            }catch(Exception e){
                e.printStackTrace();
            }
    }  
         public static void main(String args[])
    {
        new Requestpg();
    }
}
        

