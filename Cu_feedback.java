package maincrm;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.util.*;

public class Cu_feedback extends JFrame implements ActionListener {
    
    Random ran = new Random();
    int number = ran.nextInt(99999);
    
    JTextField tfname,tfcid,tfmail,tfaddress,tfphone;
    JTextArea tafdback;
    JButton add,back;
    Conn conn=new Conn();
    Cu_feedback()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Customer Feedback");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading); 
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(50,150,150,30);
        lbname.setFont(new Font("serif",Font.PLAIN,20));
        add(lbname);
        
        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel lbfname=new JLabel("Customer ID");
        lbfname.setBounds(50,200,200,30);
        lbfname.setFont(new Font("serif",Font.PLAIN,20));
        add(lbfname);
        
        tfcid=new JTextField();
        tfcid.setBounds(200,200,150,30);
        add(tfcid);
        
        JLabel lbmail=new JLabel("E-Mail");
        lbmail.setBounds(50,250,200,30);
        lbmail.setFont(new Font("serif",Font.PLAIN,20));
        add(lbmail);
        
        tfmail=new JTextField();
        tfmail.setBounds(200,250,150,30);
        add( tfmail);
        
        JLabel lbphone=new JLabel("Phone");
        lbphone.setBounds(400,150,200,30);
        lbphone.setFont(new Font("serif",Font.PLAIN,20));
        add(lbphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(550,150,150,30);
        add(tfphone);
        
        JLabel lbaddress=new JLabel("Address");
        lbaddress.setBounds(50,300,200,30);
        lbaddress.setFont(new Font("serif",Font.PLAIN,20));
        add(lbaddress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,300,150,30);
        add(tfaddress);
        
        JLabel lbfdback=new JLabel("Feedback");
        lbfdback.setBounds(400,250,200,30);
        lbfdback.setFont(new Font("serif",Font.PLAIN,20));
        add(lbfdback);
        
        tafdback=new JTextArea();
        tafdback.setBounds(550,250,200,100);
        tafdback.setBackground(Color.LIGHT_GRAY);
        add(tafdback);
        
        add=new JButton("Submit Feedback");
        add.setBounds(250,450,150,40 );

        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(450,450,150,40 );

        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Requestpg();
    }
});
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
     public void focusLost(FocusEvent e) throws SQLException {
       String cid1 = tfcid.getText();
       
       String str = "select * from customer where cid='"+cid1+"'";
       ResultSet rs = (ResultSet) conn.s.executeQuery(str);    
       if(rs.next()){
            tfname.setText(rs.getString("name"));
            tfmail.setText(rs.getString("mail"));
            tfphone.setText(rs.getString("phone"));
            tfaddress.setText(rs.getString("address"));
       }
    }

    @Override
     public void actionPerformed(ActionEvent ae)
    {
//        if(ae.getSource() == add){
//            String name = tfname.getText();
//            String cid = tfcid.getText();
//            String mail= tfmail.getText();
//            String phone= tfphone.getText();
//            String address= tfaddress.getText();
////            String feedback= tfaddress.getText();
//            
//            try{
//                
//                String query="insert into feedback values('"+name+"','"+cid+"','"+mail+"','"+phone+"','"+address+"')";
//                conn.s.executeUpdate(query);
//                JOptionPane.showMessageDialog(null,"Feedback Added Successfully");
//                setVisible(false);
//                new Requestpg();
//                
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//        }
//        else
//        {
//           setVisible (false);
//           new Requestpg();
//        }
    }
    
    public static void main(String aegs[])
    {
        new Cu_feedback();
    }
    
}