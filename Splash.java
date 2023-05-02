package maincrm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Splash extends JFrame implements ActionListener{
    JButton admin, customer;
    Splash()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel l=new JLabel("CUSTOMER REQUEST MANAGEMENT SYSTEM");
        l.setBounds(60,10,1200,60);
        l.setFont(new Font("serif",Font.PLAIN,40));
        l.setForeground(Color.RED);        
        add(l);
        
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("splash.jpeg"));
        Image i1=i.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel img=new JLabel(i2);
        img.setBounds(50,80,900,500);
        add(img);
        
        admin=new JButton("ADMIN");
        admin.setBounds(300,400,300,70);
        admin.setBackground(Color.BLACK);
        admin.setForeground(Color.WHITE);
        admin.addActionListener(this);
        img.add(admin);
        
        customer=new JButton("CUSTOMER");
        customer.setBounds(300,300,300,70);
        customer.setBackground(Color.BLACK);
        customer.setForeground(Color.WHITE);
        customer.addActionListener(this);
        img.add(customer);
        
        
        setSize(1000,650);
        setLocation(100,50);
        setVisible(true);
        

    }
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource() == customer)
       {
           setVisible(false);
           new Requestpg();
       }
        if(ae.getSource() == admin)
        {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String args[])
    {
        new Splash();
    }
}