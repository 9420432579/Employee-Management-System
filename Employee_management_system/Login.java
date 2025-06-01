package Employee_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    private JTextField fusername;
    private JPasswordField fpassword;
    JButton btnLogin, btnBack;

    Login() {
        setTitle("Employee Management System - Login");

        // Heading
        JLabel loginLabel = new JLabel("Login Employee");
        loginLabel.setBounds(300, 40, 500, 60);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 50));
        loginLabel.setForeground(Color.RED);
        add(loginLabel);

        // Username Label
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(200, 170, 300, 40);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(usernameLabel);

        // Username TextField
        fusername = new JTextField();
        fusername.setBounds(320, 180, 200, 30);
        add(fusername);

        // Password Label
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(200, 220, 300, 40);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(passwordLabel);

        // Password Field
        fpassword = new JPasswordField();
        fpassword.setBounds(320, 225, 200, 30);
        add(fpassword);

        // Login Button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(220, 300, 120, 40);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
        btnLogin.setBackground(Color.BLUE);
        btnLogin.setForeground(Color.RED);
        btnLogin.addActionListener(this);
        add(btnLogin);

        // Back Button
        btnBack = new JButton("Back");
        btnBack.setBounds(390, 300, 120, 40);
        btnBack.setFont(new Font("Arial", Font.BOLD, 20));
        btnBack.setBackground(Color.BLUE);
        btnBack.setForeground(Color.RED);
        btnBack.addActionListener(this);
        add(btnBack);

        // Login Image
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image l2 = l1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        JLabel imageLabel = new JLabel(new ImageIcon(l2));
        imageLabel.setBounds(600, 160, 300, 200);
        add(imageLabel);

        // Background Image
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/b1.png"));
        Image bgImg = bgIcon.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, 1170, 650);
        add(background);

        // JFrame Properties
        setSize(1170, 650);
        setLocation(150, 50);
        setLayout(null);
        setVisible(true);
    }
//overrite function
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String username = fusername.getText();
            String password = new String(fpassword.getPassword());

            // username and password validate
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter both username and password.");
                return;
            }

            try {
                connect conn = new connect();
                String query = "SELECT * FROM Login WHERE username = ? AND password = ?";
                PreparedStatement pst = conn.connection.prepareStatement(query);
                pst.setString(1, username);
                pst.setString(2, password);
                ResultSet resultSet = pst.executeQuery();

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    setVisible(false);
                    new dashbord(); // Load dashboard/home screen
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database Error");
            }
        } else if (e.getSource() == btnBack) {
            dispose();
            new index(); // Go back to index/home page
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
