package Employee_management_system;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class add extends JFrame {

    add() {
        // Heading
        JLabel heading = new JLabel("Add Employee");
        heading.setBounds(300, -50, 300, 300);
        heading.setFont(new Font("Algerian", Font.BOLD, 30));
        heading.setForeground(Color.darkGray);
        add(heading);

        // Labels
        JLabel name = new JLabel("Name");
        name.setBounds(150, 210, 300, 30);
        name.setFont(new Font("Arial", Font.BOLD, 16));
        add(name);

        JLabel ID = new JLabel("ID");
        ID.setBounds(150, 250, 300, 30);
        ID.setFont(new Font("Arial", Font.BOLD, 16));
        add(ID);

        JLabel username = new JLabel("Username");
        username.setBounds(150, 290, 300, 30);
        username.setFont(new Font("Arial", Font.BOLD, 16));
        add(username);

        JLabel email = new JLabel("Email");
        email.setBounds(150, 330, 300, 30);
        email.setFont(new Font("Arial", Font.BOLD, 16));
        add(email);

        JLabel contact = new JLabel("Contact Number");
        contact.setBounds(150, 370, 300, 30);
        contact.setFont(new Font("Arial", Font.BOLD, 16));
        add(contact);

        JLabel password = new JLabel("Password");
        password.setBounds(150, 410, 300, 30);
        password.setFont(new Font("Arial", Font.BOLD, 16));
        add(password);

        // Text Fields
        JTextField fName = new JTextField();
        fName.setBounds(320, 210, 300, 25);
        fName.setBorder(new MatteBorder(0, 0, 2, 0, Color.GRAY));
        add(fName);

        JTextField fID = new JTextField();
        fID.setBounds(320, 250, 300, 25);
        fID.setBorder(new MatteBorder(0, 0, 2, 0, Color.GRAY));
        add(fID);

        JTextField tfUsername = new JTextField();
        tfUsername.setBounds(320, 290, 300, 25);
        tfUsername.setBorder(new MatteBorder(0, 0, 2, 0, Color.GRAY));
        add(tfUsername);

        JTextField tfEmail = new JTextField();
        tfEmail.setBounds(320, 330, 300, 25);
        tfEmail.setBorder(new MatteBorder(0, 0, 2, 0, Color.GRAY));
        add(tfEmail);
        

        JTextField tfContact = new JTextField();
        tfContact.setBounds(320, 370, 300, 25);
        tfContact.setBorder(new MatteBorder(0, 0, 2, 0, Color.GRAY));
        add(tfContact);

        JPasswordField pfPassword = new JPasswordField();
        pfPassword.setBounds(320, 410, 300, 25);
        pfPassword.setBorder(new MatteBorder(0, 0, 2, 0, Color.GRAY));
        add(pfPassword);

        JButton ad=new JButton("add");
        ad.setBounds(200, 470, 150, 50);
        ad.setFont(new Font("arial",Font.ITALIC,15));
        ad.setForeground(Color.black);
        ad.setBackground(Color.BLUE);
        add(ad);

        JButton exit=new JButton("Exit");
        exit.setBounds(400, 470, 150, 50);
        exit.setFont(new Font("arial",Font.ITALIC,15));
        exit.setForeground(Color.black);
        exit.setBackground(Color.BLUE);
        add(exit);


        // Frame setup
        setTitle("Add Employee");
        setSize(900, 700);
        setLayout(null);
        setLocationRelativeTo(null); // center the frame
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ad.addActionListener(e ->{
            String nameText=fName.getText();
            String idTest=fID.getText();
            String usernameText=tfUsername.getText();
            String contactText=tfContact.getText();
            String emailText=tfEmail.getText();
            String passwordText=pfPassword.getText();

            if(nameText.isEmpty()||idTest.isEmpty()||usernameText.isEmpty()||contactText.isEmpty()||emailText.isEmpty()||passwordText.isEmpty()){
                JOptionPane.showMessageDialog(null,"required field");
                return;
            }
            try {

                connect conn=new connect();
                String query="INSERT INTO Employee(id,name,username,email,contact,password) VALUE(?,?,?,?,?,?)";
                PreparedStatement pst = conn.connection.prepareStatement(query);
                pst.setInt(1, Integer.parseInt(idTest));
                pst.setString(2, nameText);
                pst.setString(3, usernameText);
                pst.setString(4,emailText);
                pst.setString(5,contactText);
                pst.setString(6,passwordText);
                int result=pst.executeUpdate();

                if(result>0){
                    JOptionPane.showMessageDialog(null, "Employee add successfully");
                    dispose();
                    new dashbord();
                }

            }  catch (SQLException excep) {
                excep.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: Employee ID or Username may already exist.");
            }

        });
        exit.addActionListener(e ->{
            new dashbord();
            dispose();
        });
    }
   
        

    public static void main(String[] args) {
        new add();
    }
}
