package javaLoginForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;

public class AdminPage extends JFrame {
    public AdminPage() {
        super("Admin Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 650);
        setLocation(170,50);
        setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Middle Name");
        model.addColumn("Last Name");
        model.addColumn("UserName");
        model.addColumn("Password");
        model.addColumn("UserType");
        model.addColumn("Email");
        model.addColumn("Phone Number");
        model.addColumn("Gender");
        model.addColumn("DoB");
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/activityjava", "root", "Somesh@Bang");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM userdetails");
            while (rs.next()) {
                Object[] row = { rs.getInt("id"), rs.getString("name"), rs.getString("middlename"), rs.getString("lastname"), rs.getString("username"), rs.getString("password"), rs.getString("usertype"), rs.getString("emailid"), rs.getString("phonenumber"),rs.getString("gender"), rs.getString("dob")};
                model.addRow(row);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JTable table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
        table.setBackground(new Color(167, 245, 245));

        JPanel buttonPanel = new JPanel();
        JButton insertButton = new JButton("Insert");
        insertButton.setFont(new Font("Segoe UI Black", 0, 18));
        JButton updateButton = new JButton("Update");
        updateButton.setFont(new Font("Segoe UI Black", 0, 18));
        JButton deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Segoe UI Black", 0, 18));
        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Segoe UI Black", 0, 18));
        buttonPanel.add(insertButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(logoutButton);
        buttonPanel.setBackground(new Color(167, 245, 245));
        add(buttonPanel, BorderLayout.SOUTH);


        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                RegForm rf1 =new RegForm("ADMIN");
                rf1.changeScr();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/activityjava", "root","Somesh@Bang");
                    Statement st = con.createStatement();
                    int selectedRow = table.getSelectedRow();
                    
                    if (selectedRow == -1) {
                        AdminPage ap0 = new AdminPage();
                        JOptionPane.showMessageDialog(null, "Select user to update ");
                        ap0.show();
                        dispose();
                    } else {
                        Object primaryKeyValue = table.getValueAt(selectedRow, 0);
                        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                        RegForm rf1 = new RegForm("UPDATE");
                        rf1.adminUpdate((int) primaryKeyValue);
                        rf1.changeScr();

                    }

                    con.close();
                } catch (Exception eee) {
                    eee.printStackTrace();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try 
                {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/activityjava", "root", "Somesh@Bang");
                    Statement st = con.createStatement();
                    int selectedRow = table.getSelectedRow();
                    
                    if(selectedRow == -1){
                        AdminPage ap2 = new AdminPage();
                        dispose();
                        JOptionPane.showMessageDialog(null, "Select user to Delete ");
                    }

                    else{
                        Object primaryKeyValue = table.getValueAt(selectedRow, 0);
                        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                        String sql = "DELETE FROM userdetails WHERE ID = ?";
                        PreparedStatement pstmt = con.prepareStatement(sql);
                        pstmt.setObject(1, primaryKeyValue);
                        pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Deleted Successfull");
                        AdminPage ap1 = new AdminPage();
                        ap1.show();
                        dispose();
                    }
                    con.close();
                }
                catch (SQLException eee) {
                    eee.printStackTrace();
                }
                
            }
        });

        logoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                MyFrame mf = new MyFrame();
                mf.show();
                dispose();
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new AdminPage();
    }
}