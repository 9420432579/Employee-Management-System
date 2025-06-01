package Employee_management_system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class delete extends JFrame {
    JTextField fid;
    JButton back, submit;

    delete() {
        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ra.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1000, 700);
        add(img);

        // Heading
        JLabel Head = new JLabel("Delete Employee");
        Head.setBounds(300, 50, 500, 100);
        Head.setFont(new Font("Arial", Font.ITALIC, 40));
        img.add(Head);

        // ID label and field
        JLabel id = new JLabel("ID");
        id.setBounds(200, 200, 300, 40);
        id.setFont(new Font("Arial", Font.ITALIC, 30));
        img.add(id);

        fid = new JTextField();
        fid.setBounds(280, 200, 200, 30);
        img.add(fid);

        // Submit button
        submit = new JButton("Delete");
        submit.setBounds(200, 300, 150, 50);
        submit.setFont(new Font("Arial", Font.BOLD, 16));
        submit.setBackground(Color.RED);
        submit.setForeground(Color.WHITE);
        img.add(submit);

        // Back button
        back = new JButton("Back");
        back.setBounds(400, 300, 150, 50);
        back.setFont(new Font("Arial", Font.BOLD, 16));
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        img.add(back);

        // Back button action
        back.addActionListener(e -> {
            new dashbord();  // Ensure dashbord.java exists
            dispose();
        });

        // Delete button action
        submit.addActionListener(e -> {
            String idText = fid.getText().trim();

            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Employee ID to delete.");
                return;
            }

            try {
                int empId = Integer.parseInt(idText);

                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to delete employee ID " + empId + "?",
                        "Confirm Deletion",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    connect conn = new connect();
                    String query = "DELETE FROM employee WHERE id = ?";
                    PreparedStatement ps = conn.connection.prepareStatement(query);
                    ps.setInt(1, empId);
                    int result = ps.executeUpdate();

                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Employee deleted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee ID not found.");
                    }

                    ps.close();
                    conn.connection.close();
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric ID.");
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database error: " + sqle.getMessage());
            }
        });

        // Frame settings
        setTitle("Delete Employee");
        setSize(1000, 700);
        setLayout(null);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new delete();
    }
}
