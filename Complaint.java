package maincrm;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Complaint extends JFrame implements ActionListener, ItemListener {


    JLabel l1, l8;
    JTextField t1;
    JTextArea cp;
    JButton b1, back;
    Choice c2;


   

    Complaint() {

        super("Customer Complaint");
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
        t1.setEditable(false);
        add(t1);

       
        
       
        
         l8 = new JLabel("Complaint");
        cp = new JTextArea();
        l8.setBounds(40, 200, 100, 25);
        cp.setBounds(160, 200, 250, 80);
        cp.setBackground(Color.gray);
        cp.setForeground(Color.WHITE);

        add(l8);
        add(cp);

        b1 = new JButton("Submit Complaint");
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
            String id = c2.getSelectedItem();
            String st = "pending";
            String sl = "NULL";
            String name=t1.getText();
            String cmp=cp.getText();
                  String qry = "insert into complaint values ('"+id+"','"+name+"','"+cmp+"','"+sl+"','"+st+"')";

                try {
                    Conn c1 = new Conn();
                    c1.s.executeUpdate(qry);
                    JOptionPane.showMessageDialog(null, "Complaint submitted");
                    this.setVisible(false);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
        }
        else {
            setVisible (false);
           new Requestpg();
        }
        
    }

    public void itemStateChanged(ItemEvent ie) {
        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from customer where cid=" + c2.getSelectedItem());
            if (rs.next()) {
                t1.setText(rs.getString("name"));
               
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Complaint();
    }

}