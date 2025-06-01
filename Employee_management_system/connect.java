package Employee_management_system;

import java.sql.*;
import javax.swing.JOptionPane;

public class connect {
    public Connection connection;
    public Statement statement;

    public connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure driver is loaded
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee_management_system", "root", "root");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace(); // Shows the exact error
            JOptionPane.showMessageDialog(null, "Database connection failed: " + e.getMessage());
        }
    }
}
