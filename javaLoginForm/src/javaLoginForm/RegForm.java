package javaLoginForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.imageio.*;
import java.io.*;

public class RegForm extends JFrame {

    Container c1;
    JLabel lheadingname, fname, mname, lname, phn, user, pass, email, dob, gen, male, female, other, address;
    JTextField txtfname, txtmname, txtlname, txtphn, txtuser, txtemail, txtdob, txtgen, txtmale, txtfemale, txtother;
    JTextArea txtaddress;
    JPasswordField txtpass;
    JCheckBox showPass1;
    JRadioButton rmale, rfemale, rother;
    JButton btnSubmit, btnReset, btnBTLogin, btnBTAdminI;
    Font fnt = new Font("Dialog", 1, 16);
    Color customColorlbl = new Color(0,0,0);
    Color customColor1 = new Color(255, 255, 125);

    RegForm(String A) {
        System.out.println(A);
        setTitle("Register Form");
        setSize(1000, 600);
        setLocation(180, 60);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c1 = getContentPane();
        c1.setLayout(null);

        if (A == "ADMIN" || A == "UPDATE") {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }

        lheadingname = new JLabel("Registration Form");
        lheadingname.setBounds(370, 30, 300, 50);
        lheadingname.setFont(new Font("Sylfaen", 1, 32));
        

        fname = new JLabel("First Name");
        fname.setBounds(100, 130, 100, 20);
        fname.setFont(fnt);
        
        txtfname = new JTextField();
        txtfname.setBounds(100, 155, 220, 30);
        txtfname.setFont(new Font("Arial Rounded MT Bold", 0, 18));
        txtfname.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        mname = new JLabel("Middle Name");
        mname.setBounds(400, 130, 100, 20);
        mname.setFont(fnt);
        txtmname = new JTextField();
        txtmname.setBounds(400, 155, 220, 30);
        txtmname.setFont(new Font("Arial Rounded MT Bold", 0, 18));
        txtmname.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        lname = new JLabel("Last Name");
        lname.setBounds(700, 130, 100, 20);
        lname.setFont(fnt);
        txtlname = new JTextField();
        txtlname.setBounds(700, 155, 220, 30);
        txtlname.setFont(new Font("Arial Rounded MT Bold", 0, 18));
        txtlname.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        phn = new JLabel("Phone No.");
        phn.setBounds(100, 210, 100, 20);
        phn.setFont(fnt);
        txtphn = new JTextField();
        txtphn.setBounds(100, 235, 220, 30);
        txtphn.setFont(new Font("Arial Rounded MT Bold", 0, 18));
        txtphn.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        user = new JLabel("Username");
        user.setBounds(400, 210, 100, 20);
        user.setFont(fnt);
        txtuser = new JTextField();
        txtuser.setBounds(400, 235, 220, 30);
        txtuser.setFont(new Font("Arial Rounded MT Bold", 0, 18));
        txtuser.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        pass = new JLabel("Password");
        pass.setBounds(700, 210, 100, 20);
        pass.setFont(fnt);
        txtpass = new JPasswordField();
        txtpass.setBounds(700, 235, 220, 30);
        txtpass.setFont(new Font("Arial Rounded MT Bold", 0, 18));
        txtpass.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        showPass1 = new JCheckBox();
        showPass1.setBounds(535, 258, 30, 30);
        Icon icon = new ImageIcon("..\\javaLoginForm\\icons8-closed-eye-20.png");
        showPass1.setIcon(icon);

        email = new JLabel("Email id");
        email.setBounds(100, 290, 110, 20);
        email.setFont(fnt);
        txtemail = new JTextField();
        txtemail.setBounds(100, 315, 220, 30);
        txtemail.setFont(new Font("Arial Rounded MT Bold", 0, 18));
        txtemail.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        dob = new JLabel("Date of Birth");
        dob.setBounds(400, 290, 100, 20);
        dob.setFont(fnt);
        txtdob = new JTextField();
        txtdob.setBounds(400, 315, 220, 30);
        txtdob.setFont(new Font("Arial Rounded MT Bold", 0, 18));
        txtdob.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        gen = new JLabel("Gender");
        gen.setBounds(700, 290, 100, 20);
        gen.setFont(fnt);

        address = new JLabel("Address");
        address.setBounds(100, 370, 100, 20);
        address.setFont(fnt);
        txtaddress = new JTextArea();
        txtaddress.setBounds(100, 395, 800, 30);
        txtaddress.setFont(new Font("Arial Rounded MT Bold", 0, 18));
        txtaddress.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        btnBTLogin = new JButton("Back");
        btnBTLogin.setBounds(250, 470, 150, 35);
        btnBTLogin.setFont(fnt);
        btnBTLogin.setBackground(Color.WHITE);
        btnBTLogin.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        Icon icon1 = new ImageIcon("..\\javaLoginForm\\icons8-left-arrow-30.png");
        btnBTLogin.setIcon(icon1);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(420, 470, 150, 35);
        btnSubmit.setFont(fnt);
        btnSubmit.setBackground(Color.WHITE);
        btnSubmit.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        btnReset = new JButton("Reset");
        btnReset.setBounds(590, 470, 150, 35);
        btnReset.setFont(fnt);
        btnReset.setBackground(Color.WHITE);
        btnReset.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        c1.setBackground(customColor1);

        c1.add(lheadingname);
        c1.add(fname);
        c1.add(mname);
        c1.add(lname);
        c1.add(phn);
        c1.add(user);
        c1.add(pass);
        c1.add(email);
        c1.add(dob);
        c1.add(gen);
        c1.add(address);

        c1.add(txtfname);
        c1.add(txtmname);
        c1.add(txtlname);
        c1.add(txtphn);
        c1.add(txtuser);
        c1.add(txtpass);
        c1.add(txtemail);
        c1.add(txtdob);
        c1.add(txtaddress);
        c1.add(btnSubmit);
        c1.add(btnReset);
        c1.add(btnBTLogin);

        lheadingname.setForeground(customColorlbl);
        fname.setForeground(customColorlbl);
        mname.setForeground(customColorlbl);
        lname.setForeground(customColorlbl);
        phn.setForeground(customColorlbl);
        user.setForeground(customColorlbl);
        pass.setForeground(customColorlbl);
        email.setForeground(customColorlbl);
        dob.setForeground(customColorlbl);
        gen.setForeground(customColorlbl);
        address.setForeground(customColorlbl);

        JRadioButton rmale = new JRadioButton("Male");
        rmale.setBounds(710, 320, 60, 20);
        rmale.setFont(fnt);
        rmale.setBackground(customColor1);
        rmale.setBorder(new MatteBorder(1, 1, 1, 1, customColor1));
        if (A == "USERUPDATE") {
            rmale.setVisible(false);
        }
        if(A == "ADMIN" || A== "UPDATE")
        {
            rmale.setBackground(new Color(167, 245, 245));
        }

        JRadioButton rfemale = new JRadioButton("Female");
        rfemale.setBounds(770, 320, 80, 20);
        rfemale.setFont(fnt);
        rfemale.setBackground(customColor1);
        if (A == "USERUPDATE") {
            rfemale.setVisible(false);
        }
        if (A == "ADMIN" || A == "UPDATE") {
            rfemale.setBackground(new Color(167, 245, 245));
        }

        JRadioButton rother = new JRadioButton("Other");
        rother.setBounds(850, 320, 100, 20);
        rother.setFont(fnt);
        rother.setBackground(customColor1);
                if (A == "USERUPDATE") {
            rother.setVisible(false);
        }
        if (A == "ADMIN" || A == "UPDATE") {
            rother.setBackground(new Color(167, 245, 245));
        }

        ButtonGroup group = new ButtonGroup();
        group.add(rmale);
        group.add(rfemale);
        group.add(rother);

        c1.add(rmale);
        c1.add(rfemale);
        c1.add(rother);

        btnBTLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MyFrame mf = new MyFrame();
                mf.show();
                dispose();
            }
        });
        System.out.println(A);

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtfname.setText("");
                txtmname.setText("");
                txtlname.setText("");
                txtphn.setText("");
                if(A!="USERUPDATE"){
                    txtuser.setText("");
                }
                txtemail.setText("");
                txtdob.setText("");
                txtpass.setText("");
                txtaddress.setText("");
                group.clearSelection();

            }
        });

        btnSubmit.addActionListener(new ActionListener() {
            String uGen;

            public void actionPerformed(ActionEvent e) {
                String uName = txtfname.getText();
                String uMiddleName = txtmname.getText();
                String uLastname = txtlname.getText();
                String uPhn = txtphn.getText();
                String uUsername = txtuser.getText();
                String uPassword = txtpass.getText();
                String uEmailid = txtemail.getText();
                String uDob = txtdob.getText();
                String uAddress = txtaddress.getText();

                if (rmale.isSelected()) {
                    uGen = "Male";
                } else if (rfemale.isSelected()) {
                    uGen = "Female";
                } else if (rother.isSelected()) {
                    uGen = "Other";
                }

                if (A == "UPDATE") {
                    System.out.println("in update ");
                    
                    if (txtuser.getText().equals("")){
                        JOptionPane.showMessageDialog(btnSubmit, "Enter a Username");
                    }
                    else if (txtpass.getText().equals("")){
                        JOptionPane.showMessageDialog(btnSubmit, "Enter a password");
                    }
                    else if (txtfname.getText().equals("") || txtmname.getText().equals("") || txtlname.getText().equals("")) {
                        JOptionPane.showMessageDialog(btnSubmit,"Fill all the Details");
                    }
                    else {
                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/activityjava","root", "Somesh@Bang");
                            String query = " UPDATE userdetails SET name=?,middlename=?,lastname=?,phonenumber=?,password=?,emailid=?,dob=?,address=?,usertype=? WHERE username = ?";
                            PreparedStatement preparedStmt = connection.prepareStatement(query);
                            preparedStmt.setString(1, uName);
                            preparedStmt.setString(2, uMiddleName);
                            preparedStmt.setString(3, uLastname);
                            preparedStmt.setString(4, uPhn);
                            preparedStmt.setString(5, uPassword);
                            preparedStmt.setString(6, uEmailid);
                            preparedStmt.setString(7, uDob);

                            preparedStmt.setString(8, uAddress);
                            preparedStmt.setString(9, "user");
                            preparedStmt.setString(10, uUsername);

                            preparedStmt.execute();
                            connection.close();
                            JOptionPane.showMessageDialog(null, "Register Successfull");
                            if (A == "ADMIN" || A == "UPDATE") {
                                AdminPage ap = new AdminPage();
                                dispose();
                            } else {
                                MyFrame mf0 = new MyFrame();
                                mf0.show();
                                dispose();
                            }
                            txtfname.setText("");
                            txtmname.setText("");
                            txtlname.setText("");
                            txtphn.setText("");
                            txtuser.setText("");
                            txtemail.setText("");
                            txtdob.setText("");
                            txtpass.setText("");
                            txtaddress.setText("");
                            group.clearSelection();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                } 
                else {
                    if (txtuser.getText().equals("")){
                        JOptionPane.showMessageDialog(btnSubmit, "Enter a Username");
                    }
                    else if (txtpass.getText().equals("")){
                        JOptionPane.showMessageDialog(btnSubmit, "Enter a password");
                    }
                    else if (txtfname.getText().equals("") || txtmname.getText().equals("") || txtlname.getText().equals("")) {
                        JOptionPane.showMessageDialog(btnSubmit,"Fill all the Details");
                    }
                    else {
                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/activityjava","root", "Somesh@Bang");
                            String query = " insert into userdetails (name,middlename,lastname,phonenumber,username,password,emailid,dob,gender,address,usertype)"+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement preparedStmt = connection.prepareStatement(query);
                            preparedStmt.setString(1, uName);
                            preparedStmt.setString(2, uMiddleName);
                            preparedStmt.setString(3, uLastname);
                            preparedStmt.setString(4, uPhn);
                            preparedStmt.setString(5, uUsername);
                            preparedStmt.setString(6, uPassword);
                            preparedStmt.setString(7, uEmailid);
                            preparedStmt.setString(8, uDob);
                            preparedStmt.setString(9, uGen);
                            preparedStmt.setString(10, uAddress);
                            preparedStmt.setString(11, "user");

                            preparedStmt.execute();
                            connection.close();
                            JOptionPane.showMessageDialog(null, "Register Successfull");
                            if (A == "ADMIN" || A == "UPDATE") {
                                AdminPage ap = new AdminPage();
                                dispose();
                            } else {
                                MyFrame mf0 = new MyFrame();
                                mf0.show();
                                dispose();
                            }
                            txtfname.setText("");
                            txtmname.setText("");
                            txtlname.setText("");
                            txtphn.setText("");
                            txtuser.setText("");
                            txtemail.setText("");
                            txtdob.setText("");
                            txtpass.setText("");
                            txtaddress.setText("");
                            group.clearSelection();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        });

        

        if (A == "ADMIN" || A == "UPDATE") {
            btnBTLogin.setVisible(false);
            dispose();
            btnBTAdminI = new JButton("Back");
            btnBTAdminI.setBounds(250, 470, 150, 35);
            btnBTAdminI.setFont(fnt);
            Icon icon2 = new ImageIcon("..\\javaLoginForm\\icons8-left-arrow-30.png");
            btnBTAdminI.setIcon(icon2);
            btnBTAdminI.setBackground(Color.WHITE);
            btnBTAdminI.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
            c1.add(btnBTAdminI);  


            btnBTAdminI.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    AdminPage ap = new AdminPage();
                    dispose();
                }
            });
        } else {
            dispose();
        }

        setVisible(true);
    }

    public void UpdateUsers(String UU) {
        String tname, tmiddlename, tlastname, tphonenumber, tusername, tpassword, temailid, tdob, tgender, taddress,tusertype;
        JButton BtnUUpdate, btnBTUser;
        JRadioButton uBTNmale, uBTNfemale, uBTNother;
        ButtonGroup userGendergrp;
        Color col = new Color(255,255,255);
        Color colbk = new Color(102, 102, 255);

        c1.setBackground(colbk);

        lheadingname.setForeground(col);
        fname.setForeground(col);
        mname.setForeground(col);
        lname.setForeground(col);
        phn.setForeground(col);
        user.setForeground(col);
        pass.setForeground(col);
        email.setForeground(col);
        dob.setForeground(col);
        gen.setForeground(col);
        address.setForeground(col);


        System.out.println(UU);
        lheadingname.setText("Update Form");
        lheadingname.setBounds(380, 30, 300, 50);
        lheadingname.setFont(new Font("Sylfaen", 1, 40));
        btnBTLogin.setVisible(false);
        btnSubmit.setVisible(false);

        BtnUUpdate = new JButton("Update");
        BtnUUpdate.setBounds(420, 470, 150, 35);
        BtnUUpdate.setFont(fnt);
        BtnUUpdate.setBackground(Color.WHITE);
        BtnUUpdate.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        c1.add(BtnUUpdate);

        uBTNmale = new JRadioButton("Male");
        uBTNmale.setBounds(710, 320, 60, 20);
        uBTNmale.setFont(fnt);
        uBTNmale.setBackground(colbk);
        uBTNmale.setForeground(col);
        uBTNmale.setBorder(new MatteBorder(1, 1, 1, 1, customColor1));
        c1.add(uBTNmale);

        uBTNfemale = new JRadioButton("Female");
        uBTNfemale.setBounds(770, 320, 80, 20);
        uBTNfemale.setFont(fnt);
        uBTNfemale.setBackground(colbk);
        uBTNfemale.setForeground(col);
        c1.add(uBTNfemale);

        uBTNother = new JRadioButton("Other");
        uBTNother.setBounds(850, 320, 100, 20);
        uBTNother.setFont(fnt);
        uBTNother.setBackground(colbk);
        uBTNother.setForeground(col);
        c1.add(uBTNother);

        userGendergrp = new ButtonGroup();
        userGendergrp.add(uBTNmale);
        userGendergrp.add(uBTNfemale);
        userGendergrp.add(uBTNother);

        btnBTUser = new JButton("Back");
        btnBTUser.setBounds(250, 470, 150, 35);
        btnBTUser.setFont(fnt);
        btnBTUser.setBackground(Color.WHITE);
        btnBTUser.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        c1.add(btnBTUser);
        Icon icon2 = new ImageIcon("..\\javaLoginForm\\icons8-left-arrow-30.png");
        btnBTUser.setIcon(icon2);

        btnBTUser.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ee){
                UserPage up = new UserPage(UU);
                up.show();
                dispose();
            }
        });

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/activityjava", "root",
                    "Somesh@Bang");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from userdetails where username = '" + UU + "'"); //
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

                txtfname.setText(tname);
                txtmname.setText(tmiddlename);
                txtlname.setText(tlastname);
                txtphn.setText(tphonenumber);
                txtuser.setText(tusername);
                txtemail.setText(temailid);
                txtdob.setText(tdob);
                txtpass.setText(tpassword);
                txtaddress.setText(taddress);

                System.out.println(tgender);

                if (tgender.equals("Male")) {
                    uBTNmale.setSelected(true);
                } else if (tgender.equals("Female")) {
                    uBTNfemale.setSelected(true);
                } else {
                    uBTNother.setSelected(true);
                }

                txtuser.setEditable(false);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        BtnUUpdate.addActionListener(new ActionListener() {
            String uGen;

            public void actionPerformed(ActionEvent ee) {
                String uName = txtfname.getText();
                String uMiddleName = txtmname.getText();
                String uLastname = txtlname.getText();
                String uPhn = txtphn.getText();
                String uUsername = txtuser.getText();
                String uPassword = txtpass.getText();
                String uEmailid = txtemail.getText();
                String uDob = txtdob.getText();
                String uAddress = txtaddress.getText();

                if (uBTNmale.isSelected()) {
                    uGen = "Male";
                } else if (uBTNfemale.isSelected()) {
                    uGen = "Female";
                } else if (uBTNother.isSelected()) {
                    uGen = "Other";
                }

                System.out.println(uName + " " + uMiddleName + " " + uLastname + " " + uPhn + " " + uUsername + " "+ uPassword + " " + uEmailid + " " + uDob + " " + uAddress);

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/activityjava","root", "Somesh@Bang");
                    String query = " UPDATE userdetails SET name=?,middlename=?,lastname=?,phonenumber=?,password=?,emailid=?,dob=?,gender = ?,address=? WHERE username = ?";
                    PreparedStatement preparedStmt = connection.prepareStatement(query);
                    preparedStmt.setString(1, uName);
                    preparedStmt.setString(2, uMiddleName);
                    preparedStmt.setString(3, uLastname);
                    preparedStmt.setString(4, uPhn);
                    preparedStmt.setString(5, uPassword);
                    preparedStmt.setString(6, uEmailid);
                    preparedStmt.setString(7, uDob);
                    preparedStmt.setString(8, uGen);
                    preparedStmt.setString(9, uAddress);
                    preparedStmt.setString(10, uUsername);

                    preparedStmt.execute();
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                txtfname.setText("");
                txtmname.setText("");
                txtlname.setText("");
                txtphn.setText("");
                txtuser.setText("");
                txtemail.setText("");
                txtdob.setText("");
                txtpass.setText("");
                txtaddress.setText("");
                JOptionPane.showMessageDialog(null, "Updated Successfully");

                UserPage up = new UserPage(UU);
                up.show();
                dispose();
            }
        });
    }

    public void adminUpdate(int uid) {
        String tname, tmiddlename, tlastname, tphonenumber, tusername, tpassword, temailid, tdob, tgender, taddress, tusertype;
        System.out.println(uid);
        JButton btnBTAdmin; 
        btnSubmit.setText("Update");
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/activityjava", "root","Somesh@Bang");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from userdetails where id = " + uid); 

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
 
                txtfname.setText(tname);
                txtmname.setText(tmiddlename);
                txtlname.setText(tlastname);
                txtphn.setText(tphonenumber);
                txtuser.setText(tusername);
                txtemail.setText(temailid);
                txtdob.setText(tdob);
                txtpass.setText(tpassword);
                txtaddress.setText(taddress);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        btnBTAdmin = new JButton("Back");
        btnBTAdmin.setBounds(250, 470, 150, 35);
        btnBTAdmin.setFont(fnt);
        Icon icon3 = new ImageIcon("..\\javaLoginForm\\icons8-left-arrow-30.png");
        btnBTAdmin.setIcon(icon3);
        btnBTAdmin.setBackground(Color.WHITE);
        btnBTAdmin.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        c1.add(btnBTAdmin);

        btnBTAdmin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                AdminPage ap = new AdminPage();
                dispose();
            }
        });
    }

    public void changeScr(){
        c1.setBackground(new Color(167, 245, 245));
    }
}
