package maincrm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Home extends JFrame implements ActionListener{
    JButton add,view,update,remove;
    
    Home()
    {
       setLayout(null);
       
       ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("home.jpeg"));
        Image i1=i.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel img=new JLabel(i2);
        img.setBounds(0,0,1120,630);
        add(img);
        
        JLabel heading=new JLabel("CUSTOMER REQUEST MANAGEMENT SYSTEM");
        heading.setBounds(530,20,600,40);
        heading.setFont(new Font("serif",Font.PLAIN,25));
        img.add(heading);
        
        add=new JButton("Add Customer");
        add.setBounds(650,80,150,40 );
        add.addActionListener(this);
        img.add(add);
                      
        view=new JButton("View Customer");
        view.setBounds(820,80,150,40 );
        view.addActionListener(this);
        img.add(view);
        
        update=new JButton("Update Customer");
        update.setBounds(650,140,150,40 );
        update.addActionListener(this);
        img.add(update);
        
        remove=new JButton("Remove Customer");
        remove.setBounds(820,140,150,40 );
        remove.addActionListener(this);
        img.add(remove);
        
       setSize(1120,630);
       setLocation(250,100);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource() == add)
       {
           setVisible(false);
           new AddCustomer();
       }
       else if(ae.getSource()== view)
       {
//            setVisible(false);
           new View();
       }
        else if(ae.getSource()== remove)
       {
            setVisible(false);
           new Dlt();
       }
       else if(ae.getSource()== update)
       {
                   
       }
           else {
                   
                }
       }
    
    public static void main(String agrs[])
    {
        new Home();
    }
}