package maincrm;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class UpdateCustomer extends JFrame implements ActionListener, ItemListener {


    JLabel l1, l3, l4, l6, l7;
    JTextField t1, t3, t4, t6, t7;
    JButton b1, back;
    Choice c2;


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


    UpdateCustomer() {

        super("Update customer");
        setLayout(null);

        c2 = new Choice();
        c2.setBounds(160, 40, 200, 25);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");

            while (rs.next()) {
                c2.add(rs.getString("cid"));
            }
        } catch (Exception e) {
        }

        JLabel emp = new JLabel("Select Customer ID");
        emp.setBounds(40, 40, 100, 20);
        add(emp);
        add(c2);

        l1 = new JLabel("Name");
        t1 = new JTextField(15);
        l1.setBounds(40, 80, 100, 25);
        t1.setBounds(160, 80, 200, 25);
        add(l1);
        add(t1);

       
        
        l3 = new JLabel("Address");
        t3 = new JTextField(15);
        l3.setBounds(40, 120, 100, 25);
        t3.setBounds(160, 120, 200, 25);
        add(l3);
        add(t3);
        l4 = new JLabel("Father name");
        t4 = new JTextField(15);
        l4.setBounds(40, 160, 100, 25);
        t4.setBounds(160, 160, 200, 25);
        add(l4);
        add(t4);
//        l5 = new JLabel("City");
//        t5 = new JTextField(15);
//        l5.setBounds(40, 240, 100, 25);
//        t5.setBounds(160, 240, 200, 25);
//        add(l5);
//        add(t5);
        l6 = new JLabel("Email");
        t6 = new JTextField(15);
        l6.setBounds(40, 200, 100, 25);
        t6.setBounds(160, 200, 200, 25);
        add(l6);
        add(t6);

        l7 = new JLabel("Phone");
        t7 = new JTextField(15);
        l7.setBounds(40, 240, 100, 25);
        t7.setBounds(160, 240, 200, 25);
        add(l7);
        add(t7);

        b1 = new JButton("Update");
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.setBounds(70, 400, 150, 40);
        add(b1);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 400, 150, 40);
        add(back);
        
        
        b1.addActionListener(this);
        back.addActionListener(this);

        c2.addItemListener(this);

        setSize(600, 550);
        setLocation(500, 200);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String n=t1.getText();
            
            String a=t3.getText();
            String fn=t4.getText();
//            String c=t5.getText();
            String e=t6.getText();
            String p=t7.getText();
            if (n.equals("") || a.equals("") || fn.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all details...");
            } else if (!isValidEmail(e)) {
                JOptionPane.showMessageDialog(null, "Invalid Email ");
            } else if (!isValidMobileNo(p)) {
                JOptionPane.showMessageDialog(null, "Invalid Phone....");
            } else {
                String qry = " update customer set name='" + n + "',address='" + a + "',fname='" + fn + 
                        "',mail='" + e + "',phone='" + p + "' where cid=" + c2.getSelectedItem();
                try {
                    Conn c1 = new Conn();
                    c1.s.executeUpdate(qry);
                    JOptionPane.showMessageDialog(null, "Customer Details Updated");
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

    public void itemStateChanged(ItemEvent ie) {
        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from customer where cid=" + c2.getSelectedItem());
            if (rs.next()) {
                t1.setText(rs.getString("name"));
                t3.setText(rs.getString("address"));
                t4.setText(rs.getString("fname"));
//                t5.setText(rs.getString("city"));
                t6.setText(rs.getString("mail"));
                t7.setText(rs.getString("phone"));
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer();
    }

}