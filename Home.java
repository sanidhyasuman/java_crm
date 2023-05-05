    package maincrm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Home extends JFrame implements ActionListener{
    JButton add,view,update,remove,solu, back;
    
    Home()
    {
       setLayout(null);
       
       ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("home2.jpg"));
        Image i1=i.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel img=new JLabel(i2);
        img.setBounds(0,0,1120,630);
        add(img);
        
        JLabel heading=new JLabel("CUSTOMER REQUEST MANAGEMENT SYSTEM");
        heading.setBounds(400,20,600,40);
        heading.setFont(new Font("serif",Font.PLAIN,25));
        img.add(heading);
        
        add=new JButton("Add Customer");
        add.setBounds(100,250,140,100 );
         add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        img.add(add);
                      
        view=new JButton("View Customer");
        view.setBounds(300,250,140,100 );
         view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        view.addActionListener(this);
        img.add(view);
        
        update=new JButton("Update Customer");
        update.setBounds(500,250,140,100 );
         update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        img.add(update);
        
        remove=new JButton("Remove Customer");
        remove.setBounds(700,250,140,100 );
         remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.addActionListener(this);
        img.add(remove);
        
        solu=new JButton("Customer Complaint");
        solu.setBounds(900,250,140,100 );
         solu.setBackground(Color.BLACK);
        solu.setForeground(Color.WHITE);
        solu.addActionListener(this);
        img.add(solu);
        
          back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(500, 500, 150, 40);
        img.add(back);
        back.addActionListener(this);

        
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
            setVisible(false);
           new UpdateCustomer();        
       }
        else if(ae.getSource()== solu)
       {
            setVisible(false);
           new Solution();        
       }
           else {
                   setVisible(false);
           new Splash();  
                }
       }
    
    public static void main(String agrs[])
    {
        new Home();
    }
}
