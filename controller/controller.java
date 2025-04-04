import java.sql.*;

public class MySQLConnection {
    public static void main(String[] args) {
        String host = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "testUser";
        String password = "testPass";
        
        // Establish connection
        try (Connection conn = DriverManager.getConnection(host, username, password)) {
            System.out.println("Connected to MySQL database");

            // insertUser(conn, "Marcus", "marcus@example.com");

        } catch (SQLException e) {
            System.out.println("Failed to connect to MySQL database");
            e.printStackTrace();
        }
    }

    // Function to insert a user into the 'users' table
    public static void insertUser(Connection conn, String name, String email) {
        String query = "INSERT INTO users (email, password) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // Set the values for the placeholders
            stmt.setString(1, name);
            stmt.setString(2, email);

            // Execute the insert query
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting user");
            // e.printStackTrace();
        }
    }
}
