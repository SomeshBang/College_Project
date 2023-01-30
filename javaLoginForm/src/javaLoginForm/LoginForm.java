package javaLoginForm;

import javax.swing.*;           
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

class MyFrame extends JFrame{

    Container c;
    JLabel lHeading,lLogin,lUserName,lPassword;
    JTextField txtUserName;
    JPasswordField txtPassword;
    JButton SignInBtn, SignUpBtn;
    JCheckBox showPass;
    JCheckBox showPasswordCheckbox;
    ButtonGroup UserTypeGroup;
    JRadioButton UTadmin, UTuser;

    MyFrame() {
        setTitle("LogIn Form");
        setSize(780, 500);
        setLocation(320, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c=getContentPane();
        c.setLayout(null);
        Color customColor = new Color(95, 16, 245);
        c.setBackground(customColor);
             
        
        lHeading = new JLabel("Training & Placement");
        lHeading.setBounds(190, 5, 500, 50);
        lHeading.setForeground(new Color(255,255,255));
        lHeading.setFont(new Font("Lucida Calligraphy", 1, 30));

        lLogin = new JLabel("Log In");
        lLogin.setBounds(330, 70, 100, 40);
        lLogin.setFont(new Font("Sylfaen", 1, 30));
        
        lUserName = new JLabel("Username");
        lUserName.setBounds(230,140,150,20);
        lUserName.setFont(new Font("Goudy Old Style", 1, 24));
        txtUserName = new JTextField();
        txtUserName.setBounds(230, 170, 300, 35);
        txtUserName.setFont(new Font("Arial Rounded MT Bold", 0, 18));
        txtUserName.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        
        
        lPassword = new JLabel("Password");
        lPassword.setBounds(230,225,100,20);
        lPassword.setFont(new Font("Goudy Old Style", 1, 24));
        txtPassword = new JPasswordField();
        txtPassword.setBounds(230, 255, 300, 35);
        txtPassword.setFont(new Font("Arial Rounded MT Bold", 0, 18));
        txtPassword.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        txtPassword.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println(txtUserName.getText());
                    System.out.println(txtPassword.getText());

                }
            }
        });

        showPass = new JCheckBox();
        showPass.setBounds(535,258,30,30);
        Icon icon = new ImageIcon("..\\javaLoginForm\\icons8-closed-eye-20.png");
        showPass.setIcon(icon);

        showPass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPass.isSelected()) {
                    txtPassword.setEchoChar((char) 0);
                    Icon icon1 = new ImageIcon("..\\javaLoginForm\\icons8-eye-20.png");
                    showPass.setIcon(icon1);
                } else {
                    txtPassword.setEchoChar('*');
                    Icon icon2 = new ImageIcon("..\\javaLoginForm\\icons8-closed-eye-20.png");
                    showPass.setIcon(icon2);
                }
            }
        });


        c.add(showPass);
            
        UserTypeGroup = new ButtonGroup();
        JRadioButton UTadmin = new JRadioButton("Admin");
        UTadmin.setBounds(300, 300, 70, 20);
        UTadmin.setBackground(customColor);

        JRadioButton UTuser = new JRadioButton("User");
        UTuser.setBounds(390, 300, 70, 20);
        UTuser.setBackground(customColor);

        UserTypeGroup = new ButtonGroup();
        UserTypeGroup.add(UTadmin);
        UserTypeGroup.add(UTuser);

    
        SignInBtn = new JButton("Sign In");
        SignInBtn.setBounds(320, 330, 100, 30);
        SignInBtn.setBackground(Color.WHITE);
        SignInBtn.setBorder(new MatteBorder(1, 1, 1, 1,Color.BLACK));

        SignUpBtn = new JButton("New User ? Sign Up");
        SignUpBtn.setBounds(300, 380, 150, 20);
        SignUpBtn.setFont(new Font("MS UI Gothic", 1, 16));
        SignUpBtn.setBackground(customColor);
        SignUpBtn.setForeground(new Color(0, 0, 153));
        SignUpBtn.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 153)));

        SignUpBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SignUpBtn.setBackground(customColor);
                SignUpBtn.setForeground(new Color(0, 0, 255));
                SignUpBtn.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 255)));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                SignUpBtn.setBackground(customColor);
                SignUpBtn.setForeground(new Color(0, 0, 153));
                SignUpBtn.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 153)));
            }
        });
        
        
        c.add(lHeading);
        c.add(lLogin);
        c.add(lUserName);
        c.add(txtUserName);
        c.add(lPassword);
        c.add(txtPassword);
        c.add(SignInBtn);
        c.add(SignUpBtn);
        c.add(UTadmin);;
        c.add(UTuser);

        SignInBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String UserType;
                String checkUType;
                if(UTadmin.isSelected())
                {
                    UserType = "admin";
                }
                else{
                    UserType = "user";
                }

                String Username = txtUserName.getText();
                String Password = txtPassword.getText();

                if(e.getSource() == SignInBtn){
                    Username = txtUserName.getText();
                    Password = new String(txtPassword.getPassword());
                    if (Username.isEmpty() || Password.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a username , password & select type.");
                        return;
                    }
                    else{
                        try {
                            if(UserType == "admin"){
                                checkUType = "admindetails";
                            }
                            else{
                                checkUType = "userdetails";
                            }

                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/activityjava","root","Somesh@Bang");
                            Statement statement = connection.createStatement();
                            PreparedStatement stmt = connection.prepareStatement("SELECT username, password, usertype FROM "+checkUType+" WHERE username = ? and password = ? and usertype = ?");
                            stmt.setString(1, Username);
                            stmt.setString(2, Password);
                            stmt.setString(3, UserType);
                            ResultSet rs = stmt.executeQuery();
                            if (rs.next()) {
                                if(UserType == "admin"){
                                    AdminPage ap = new AdminPage();
                                    ap.show();
                                    dispose();
                                }
                                else{
                                    UserPage up = new UserPage(Username);
                                    up.show();
                                    dispose();
                                }
                                System.out.println("Login successful!");
                            } else {
                                System.out.println("Invalid username or password.");
                            }
                            connection.close();
                        } catch (Exception ee) {
                            System.out.println(ee);
                        }
                    }
                }               
            }
        });

        SignUpBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegForm rf = new RegForm(" ");
                rf.show();
                dispose();
            }
        });
        
        setVisible(true);        
    }
    public void validation(){
        
    }
}

class LoginForm{
    public static void main(String[] args) {
        MyFrame mf = new MyFrame();
        // RegForm rf = new RegForm("");
        // AdminPage ap = new AdminPage();
        // UserPage up =  new UserPage("avdhut123");
    }    
}
