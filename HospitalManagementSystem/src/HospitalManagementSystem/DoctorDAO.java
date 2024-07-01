package HospitalManagementSystem;

import java.sql.*;

public class DoctorDAO {
    public void addDoctor(Doctor doctor) throws SQLException {
        String sql = "INSERT INTO doctors (first_name, last_name, specialty, contact_number, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, doctor.getFirstName());
            pstmt.setString(2, doctor.getLastName());
            pstmt.setString(3, doctor.getSpecialty());
            pstmt.setString(4, doctor.getContactNumber());
            pstmt.setString(5, doctor.getEmail());
            pstmt.executeUpdate();
        }
    }

    public void viewDoctors() throws SQLException {
        String sql = "SELECT * FROM doctors";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("First Name: " + rs.getString("first_name"));
                System.out.println("Last Name: " + rs.getString("last_name"));
                System.out.println("Specialty: " + rs.getString("specialty"));
                System.out.println("Contact Number: " + rs.getString("contact_number"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println();
            }
        }
    }

    public void updateDoctor(Doctor doctor) throws SQLException {
        String sql = "UPDATE doctors SET first_name = ?, last_name = ?, specialty = ?, contact_number = ?, email = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, doctor.getFirstName());
            pstmt.setString(2, doctor.getLastName());
            pstmt.setString(3, doctor.getSpecialty());
            pstmt.setString(4, doctor.getContactNumber());
            pstmt.setString(5, doctor.getEmail());
            pstmt.setInt(6, doctor.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteDoctor(int id) throws SQLException {
        String sql = "DELETE FROM doctors WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
