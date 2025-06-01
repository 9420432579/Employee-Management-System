package Employee_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class dashbord extends JFrame {

    JButton add, delete, view, exit;

    dashbord() {
        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1500, 700);
        add(img);

        // Heading
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(450, 20, 700, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(Color.MAGENTA);
        img.add(heading); 

   
        add = new JButton("Add an Employee");
        add.setFont(new Font("Arial", Font.BOLD, 20));
        add.setBounds(500, 100, 300, 60);
        img.add(add);

        delete = new JButton("Delete an Employee");
        delete.setFont(new Font("Arial", Font.BOLD, 20));
        delete.setBounds(500, 180, 300, 60);
        img.add(delete);

        view = new JButton("View an Employee");
        view.setFont(new Font("Arial", Font.BOLD, 20));
        view.setBounds(500, 260, 300, 60);
        img.add(view);

        exit = new JButton("Exit");
        exit.setFont(new Font("Arial", Font.BOLD, 20));
        exit.setBounds(500, 340, 300, 60);
        img.add(exit);

        // Frame 
        setTitle("Dashbord");
        setSize(1500, 700);
        setLayout(null);
        setLocation(10, 20);
        setVisible(true);

        //connection
        add.addActionListener(e -> {
            new add();
            dispose();
        });

        delete.addActionListener(e -> {
            new delete();
            dispose();
        });
        view.addActionListener(e -> {
            new View();
            dispose();
        });

        //exit code
        exit.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        new dashbord();
    }
}
