package maincrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCustomer extends JFrame implements ActionListener {
    
    Random ran = new Random();
    int number = ran.nextInt(99999);
    
    JTextField tfname,tffname,tfmail,tfaddress,tfphone;
    JDateChooser dcdob;
    JComboBox age;
    JLabel custId;
    JButton add,back;
     public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidMobileNo(String str) {
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher match = ptrn.matcher(str);
        return (match.find() && match.group().equals(str));
    }

    
    AddCustomer()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Add Customer Details");
        heading.setBounds(240,30,450,30);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading); 
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(80,150,150,30);
        lbname.setFont(new Font("serif",Font.PLAIN,20));
        add(lbname);
        
        tfname=new JTextField();
        tfname.setBounds(200,150,150,20);
        add(tfname);
        

        
        JLabel lbmail=new JLabel("E-Mail");
        lbmail.setBounds(50,250,200,30);
        lbmail.setFont(new Font("serif",Font.PLAIN,20));
        add(lbmail);
        
        tfmail=new JTextField();
        tfmail.setBounds(200,250,150,30);
        add( tfmail);
        
        JLabel lbphone=new JLabel("Phone");
        lbphone.setBounds(50,200,200,30);
        lbphone.setFont(new Font("serif",Font.PLAIN,20));
        add(lbphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(200,200,150,30);
        add(tfphone);
        
        JLabel lbaddress=new JLabel("Address");
        lbaddress.setBounds(50,300,200,30);
        lbaddress.setFont(new Font("serif",Font.PLAIN,20));
        add(lbaddress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,300,150,30);
        add(tfaddress);
        
        JLabel cusId=new JLabel("Customer Id");
        cusId.setBounds(50,350,200,30);
        cusId.setFont(new Font("serif",Font.PLAIN,20));
        add(cusId);
        
        custId=new JLabel("" + number);
        custId.setBounds(200,350,200,30);
        custId.setFont(new Font("serif",Font.PLAIN,20));
        add(custId);
        
        add=new JButton("Add Details");
        add.setBounds(100,450,150,40 );

        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(300,450,150,40 );

        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(700,600);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==add)
        {
            String name = tfname.getText();

            String mail= tfmail.getText();
            String phone= tfphone.getText();
            String address= tfaddress.getText();
            String cusId= custId.getText();
            if (name.equals("") || address.equals("") ) {
                JOptionPane.showMessageDialog(null, "Please fill all details...");
            } else if (!isValidEmail(mail)) {
                JOptionPane.showMessageDialog(null, "Invalid Email ");
            } else if (!isValidMobileNo(phone)) {
                JOptionPane.showMessageDialog(null, "Invalid Phone....");
            } else {
                String qry ="insert into customer values('"+name+"',"
                        + "'"+mail+"','"+phone+"','"+address+"','"+cusId+"')";
                try {
                    Conn c1 = new Conn();
                    c1.s.executeUpdate(qry);
                    JOptionPane.showMessageDialog(null, "Customer Details Added");
                    this.setVisible(false);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        }
        else {
            setVisible (false);
           new Home();
        }
    }
    
    public static void main(String aegs[])
    {
        new AddCustomer();
    }
    
}
