package maincrm;

import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class View extends JFrame {
    private JTable table;
    JButton back;
    private DefaultTableModel model;
     Connection con;
   ResultSet rs;
   PreparedStatement pst;

    public View() {
         getContentPane().setBackground(Color.WHITE);
        setTitle("Customer Request Table");
        setSize(600, 400);
        
//        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] columnNames = {"Name", "Mail","Phone","Address","Customer ID"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        setVisible(true);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/saanu","root","");
            pst=con.prepareStatement("select * from customer");
            rs= pst.executeQuery();
            com.mysql.cj.jdbc.result.ResultSetMetaData rsmd = (com.mysql.cj.jdbc.result.ResultSetMetaData) rs.getMetaData();
            int n = rsmd.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            while(rs.next())
            {
                Vector v = new Vector();
                for(int i = 1;i<=n;i++){
                    v.add(rs.getString("name"));
                    v.add(rs.getString("mail"));
                    v.add(rs.getString("phone"));
                    v.add(rs.getString("address"));
                    v.add(rs.getString("cid"));
       
                }
//                System.out.print(v);
                dtm.addRow(v);
            }
        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(Fview.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

//    public void addRow(Object[] rowData) {
//        model.addRow(rowData);
//    }
    public static void main(String args[]) {
        View view = new View();
    }
    
}

