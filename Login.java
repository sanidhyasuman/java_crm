package maincrm;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    
    JTextField tfuser,tfpass;
    
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lbuser=new JLabel("Username");
        lbuser.setBounds(40,20,100,30);
        add(lbuser);
        
        tfuser=new JTextField();
        tfuser.setBounds(150,20,150,30);
        add(tfuser);
        
        JLabel lbpass=new JLabel("Password");
        lbpass.setBounds(40,70,100,30);
        add(lbpass);
        
        tfpass=new JTextField();
        tfpass.setBounds(150,70,150,30);
        add(tfpass);
        
        JButton login=new JButton("LOGIN");
        login.setBounds(150,140,150,50);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("login.jpeg"));
        Image i1=i.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel img=new JLabel(i2);
        img.setBounds(350,0,200,200);
        add(img);
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        try{
            String username = tfuser.getText();
            String password = tfpass.getText();
            
            Conn c=new Conn();
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
                
            }else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);
            }
            
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        new Login();
    }
}
