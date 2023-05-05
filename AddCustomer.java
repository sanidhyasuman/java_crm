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
        
        JLabel lbfname=new JLabel("Father Name");
        lbfname.setBounds(400,150,200,30);
        lbfname.setFont(new Font("serif",Font.PLAIN,20));
        add(lbfname);
        
        tffname=new JTextField();
        tffname.setBounds(550,150,150,30);
        add(tffname);
        
        JLabel lbdob=new JLabel("Date Of Birth");
        lbdob.setBounds(50,200,200,30);
        lbdob.setFont(new Font("serif",Font.PLAIN,20));
        add(lbdob);
        
        dcdob=new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
        JLabel lbage=new JLabel("Age");
        lbage.setBounds(400,200,200,30);
        lbage.setFont(new Font("serif",Font.PLAIN,20));
        add(lbage);
        
        String a[]={"18","19","20","21","22","23","24","25","26","27","28","29","30"};
        age=new JComboBox(a);
        age.setBackground(Color.WHITE);
        age.setBounds(550,200,150,30);
        add(age);
        
        JLabel lbmail=new JLabel("E-Mail");
        lbmail.setBounds(50,250,200,30);
        lbmail.setFont(new Font("serif",Font.PLAIN,20));
        add(lbmail);
        
        tfmail=new JTextField();
        tfmail.setBounds(200,250,150,30);
        add( tfmail);
        
        JLabel lbphone=new JLabel("Phone");
        lbphone.setBounds(400,250,200,30);
        lbphone.setFont(new Font("serif",Font.PLAIN,20));
        add(lbphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(550,250,150,30);
        add(tfphone);
        
        JLabel lbaddress=new JLabel("Address");
        lbaddress.setBounds(50,300,200,30);
        lbaddress.setFont(new Font("serif",Font.PLAIN,20));
        add(lbaddress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,300,150,30);
        add(tfaddress);
        
        JLabel cusId=new JLabel("Customer Id");
        cusId.setBounds(400,300,200,30);
        cusId.setFont(new Font("serif",Font.PLAIN,20));
        add(cusId);
        
        custId=new JLabel("" + number);
        custId.setBounds(550,300,200,30);
        custId.setFont(new Font("serif",Font.PLAIN,20));
        add(custId);
        
        add=new JButton("Add Details");
        add.setBounds(250,450,150,40 );

        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(450,450,150,40 );

        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==add)
        {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String Age= (String) age.getSelectedItem();
            String mail= tfmail.getText();
            String phone= tfphone.getText();
            String address= tfaddress.getText();
            String cusId= custId.getText();
            if (name.equals("") || address.equals("") || fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all details...");
            } else if (!isValidEmail(mail)) {
                JOptionPane.showMessageDialog(null, "Invalid Email ");
            } else if (!isValidMobileNo(phone)) {
                JOptionPane.showMessageDialog(null, "Invalid Phone....");
            } else {
                String qry ="insert into customer values('"+name+"','"+fname+"','"+dob+"','"+Age+"',"
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
