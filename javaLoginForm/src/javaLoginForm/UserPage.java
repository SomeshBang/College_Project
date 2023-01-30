package javaLoginForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class UserPage extends JFrame {
    Container c3;
    JLabel twelcome;
    JButton tLogoutBtn, tUpdateBtn;
    JTextArea tout;
    String tname, tmiddlename, tlastname, tphonenumber, tusername, tpassword, temailid, tdob, tgender, taddress,
            tusertype;

    UserPage(String usName) {
        setTitle("Userpage Page");
        setSize(750, 580);
        setLocation(180, 60);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c3 = getContentPane();
        c3.setLayout(null);
        c3.setBackground(new Color(102, 102, 255));

        twelcome = new JLabel("Welcome");
        twelcome.setBounds(190, 20, 500, 50);
        twelcome.setFont(new Font("Monotype Corsiva", 3, 50));
        twelcome.setForeground(new java.awt.Color(255, 255, 255));
        c3.add(twelcome);

        tout = new JTextArea();
        tout.setSize(500, 420);
        tout.setLocation(20, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        tout.setForeground(new java.awt.Color(0, 0, 153));
        c3.add(tout);

        tUpdateBtn = new JButton("Update");
        tUpdateBtn.setBounds(555, 200, 150, 40);
        tUpdateBtn.setBackground(new Color(153, 153, 255));
        tUpdateBtn.setFont(new Font("Segoe UI Black", 1, 18));
        tUpdateBtn.setForeground(Color.white);
        c3.add(tUpdateBtn);

        tUpdateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegForm rff = new RegForm("USERUPDATE");
                rff.UpdateUsers(usName);
                dispose();
            }
        });

        tLogoutBtn = new JButton("Logout");
        tLogoutBtn.setBounds(555, 300, 150, 40);
        tLogoutBtn.setBackground(new Color(153, 153, 255));
        tLogoutBtn.setFont(new Font("Segoe UI Black", 1, 18));
        tLogoutBtn.setForeground(Color.white);
        c3.add(tLogoutBtn);

        tLogoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MyFrame mf = new MyFrame();
                mf.show();
                dispose();
            }
        });

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/activityjava", "root",
                    "Somesh@Bang");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from userdetails where username = '" + usName + "'"); //
            if (rs.next()) {
                tname = rs.getString("name");
                tmiddlename = rs.getString("middlename");
                tlastname = rs.getString("lastname");
                tusername = rs.getString("username");
                tpassword = rs.getString("password");
                temailid = rs.getString("emailid");
                tphonenumber = rs.getString("phonenumber");
                tgender = rs.getString("gender");
                tdob = rs.getString("dob");
                taddress = rs.getString("address");
                tusertype = rs.getString("usertype");

                twelcome.setText("Welcome "+tname);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tout.setText(
                "\n Full Name : " + tname + " " + tmiddlename + " " + tlastname
                        + " \n----------------------------------------------------------------------" +
                        "  User Name : " + tusername
                        + " \n----------------------------------------------------------------------" +
                        "  User Password : " + tpassword
                        + " \n----------------------------------------------------------------------" +
                        "  Email Id : " + temailid
                        + " \n----------------------------------------------------------------------" +
                        "  Phone Number : " + tphonenumber
                        + " \n----------------------------------------------------------------------" +
                        "  Gender : " + tgender
                        + " \n----------------------------------------------------------------------" +
                        "  Date of Birth : " + tdob
                        + " \n----------------------------------------------------------------------" +
                        "  Address : " + taddress
                        + " \n----------------------------------------------------------------------" +
                        "  User Type : " + tusertype
                        + " \n----------------------------------------------------------------------");
        tout.setFont(new Font("Sitka Small", 1, 18));

        setVisible(true);
    }
}