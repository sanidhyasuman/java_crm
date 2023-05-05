package maincrm;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Cmp_status extends JFrame implements ActionListener, ItemListener {


    JLabel l1, l5, l6, l7, l8;
    JTextField t1;
    JTextArea cp,sl;
    JButton b1, back;
    Choice c2;


   

    Cmp_status() {

        super("Complaint status");
        setLayout(null);

        c2 = new Choice();
        c2.setBounds(160, 40, 200, 25);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from complaint");

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
        l8.setBounds(40, 120, 100, 25);
         cp = new JTextArea();
        cp.setBounds(160, 120, 250, 70);
        cp.setBackground(Color.gray);
        cp.setForeground(Color.WHITE);
        cp.setEditable(false);
        add(l8);
        add(cp);

        l7 = new JLabel("Solution");
        sl = new JTextArea();
        l7.setBounds(40, 200, 100, 25);
        sl.setBounds(160, 200, 250, 80);
        sl.setBackground(Color.gray);
        sl.setForeground(Color.WHITE);
        sl.setEditable(false);
        add(l7);
        add(sl);
        
         l6 = new JLabel("Status : ");
        l6.setBounds(40, 300, 100, 25);
        
        add(l6);
        
        l5 = new JLabel();
        l5.setBounds(160, 300, 100, 25);
        add(l5);
        l5.setForeground(Color.RED);  
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(210, 400, 150, 40);
        add(back);
        
        
//        b1.addActionListener(this);
        back.addActionListener(this);

        c2.addItemListener(this);

        setSize(600, 550);
        setLocation(500, 200);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        setVisible (false);
           new Requestpg();
        
    }

    public void itemStateChanged(ItemEvent ie) {
        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from complaint where cid=" + c2.getSelectedItem());
            if (rs.next()) {
                t1.setText(rs.getString("name"));
                cp.setText(rs.getString("complaint"));
                sl.setText(rs.getString("solution"));
                l5.setText(rs.getString("status"));
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Cmp_status();
    }

}