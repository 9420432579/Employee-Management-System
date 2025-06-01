import Employee_management_system.connect;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
    JTable table;
    DefaultTableModel model;
    JButton member, booka, issue_book, Rbook;

    public View() {
        // Set frame properties
        setTitle("Book View");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and style buttons
        member = createButton("Member");
        booka = createButton("Books");
        issue_book = createButton("Issue Book");
        Rbook = createButton("Return Book");

        // Top panel with padding and left-aligned buttons
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Outer padding
        topPanel.add(member);
        topPanel.add(booka);
        topPanel.add(issue_book);
        topPanel.add(Rbook);
        add(topPanel, BorderLayout.NORTH);

        // Define table columns
        String[] columns = {"ID", "Name", "Title", "Type"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        // Style table
        table.setFont(new Font("Arial", Font.PLAIN, 18));
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));

        // Table inside scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Center panel for table with padding
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // Load table data
        loadBooks();

        // Display window
        setVisible(true);
    }

    // Helper method to style buttons
    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 16));
        btn.setBackground(Color.BLUE);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setMargin(new Insets(10, 20, 10, 20)); // Internal padding
        return btn;
    }

    // Load data into table
    private void loadBooks() {
        try {
            connect conn = new connect();
            String query = "SELECT * FROM BOOK";
            Statement stmt = conn.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String title = rs.getString("TITLE");
                String type = rs.getString("TYPE");

                Object[] row = {id, name, title, type};
                model.addRow(row);
            }

            rs.close();
            stmt.close();
            conn.connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load data.");
        }
    }

    public static void main(String[] args) {
        new View();
    }
}
