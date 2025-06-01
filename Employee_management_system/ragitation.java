package Employee_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
public class ragitation extends JFrame {

    JTextField fname,fLast,fusername,fcontact;
    JPasswordField fPassword;
    JButton Ragitration,Back,Login;



    public ragitation(){
        JLabel Ragi=new JLabel("Ragitration form");
        Ragi.setBounds(150,20,400,60);
        Ragi.setFont(new Font("arial", Font.BOLD, 40));
        Ragi.setForeground(Color.MAGENTA);
        add(Ragi); 

        JLabel Name=new JLabel("Name");
        Name.setBounds(100,100,100,20);
        Name.setFont(new Font("arial",Font.BOLD,20));
        add(Name);

        fname=new JTextField();
        fname.setBounds(260,100,190,20);
        add(fname);

        JLabel Last=new JLabel("Last");
        Last.setBounds(100,130,100,20);
        Last.setFont(new Font("arial",Font.BOLD,20));
        add(Last);

        fLast=new JTextField();
        fLast.setBounds(260,130,190,20);
        add(fLast);

        JLabel username=new JLabel("Username");
        username.setBounds(100,160,100,20);
        username.setFont(new Font("arial",Font.BOLD,20));
        add(username);

        fusername=new JTextField();
        fusername.setBounds(260,160,190,20);
        add(fusername);

        JLabel password=new JLabel("Password");
        password.setBounds(100,190,100,20);
        password.setFont(new Font("arial",Font.BOLD,20));
        add(password);

        fPassword=new JPasswordField();
        fPassword.setBounds(260,190,190,20);
        add(fPassword);

        JLabel contact=new JLabel("Contact");
        contact.setBounds(100,220,100,20);
        contact.setFont(new Font("arial",Font.BOLD,20));
        add(contact);  

        fcontact=new JTextField();
        fcontact.setBounds(260,220,190,20);
        add(fcontact);


        JButton Ragitration=new JButton("Submit");
        Ragitration.setBounds(110, 280, 150, 40);
        Ragitration.setForeground(Color.blue);
        Ragitration.setBackground(Color.cyan);

        Ragitration.setFont(new Font("arial",Font.BOLD,15));
        add(Ragitration);

        JButton Back=new JButton("Back");
        Back.setBounds(300, 280, 150, 40);
        Back.setForeground(Color.blue);
        Back.setBackground(Color.cyan);
        Back.setFont(new Font("arial",Font.BOLD,15));
        add(Back);

         JButton Login=new JButton("Login Here");
        Login.setBounds(130, 350, 300, 25);
        Login.setForeground(Color.blue);
        Login.setBackground(Color.cyan);

        Login.setFont(new Font("arial",Font.BOLD,15));
        add(Login);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/ra.jpg"));
        Image i2=i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,800,500);
        add(img);

         

        setSize(800,500);
        setLayout(null);
        setLocation(150, 40);
        setVisible(true);
    }
   
   
    public static void main(String[] args) {
    new ragitation();   
   }
}
