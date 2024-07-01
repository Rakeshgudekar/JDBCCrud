package HospitalManagementSystem;

import java.sql.*;

public class PatientDAO {
    public void addPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO patients (first_name, last_name, dob, gender, contact_number, address) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, patient.getFirstName());
            pstmt.setString(2, patient.getLastName());
            pstmt.setDate(3, Date.valueOf(patient.getDob()));
            pstmt.setString(4, patient.getGender());
            pstmt.setString(5, patient.getContactNumber());
            pstmt.setString(6, patient.getAddress());
            pstmt.executeUpdate();
        }
    }

    public void viewPatients() throws SQLException {
        String sql = "SELECT * FROM patients";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("First Name: " + rs.getString("first_name"));
                System.out.println("Last Name: " + rs.getString("last_name"));
                System.out.println("Date of Birth: " + rs.getDate("dob"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Contact Number: " + rs.getString("contact_number"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println();
            }
        }
    }

    public void updatePatient(Patient patient) throws SQLException {
        String sql = "UPDATE patients SET first_name = ?, last_name = ?, dob = ?, gender = ?, contact_number = ?, address = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, patient.getFirstName());
            pstmt.setString(2, patient.getLastName());
            pstmt.setDate(3, Date.valueOf(patient.getDob()));
            pstmt.setString(4, patient.getGender());
            pstmt.setString(5, patient.getContactNumber());
            pstmt.setString(6, patient.getAddress());
            pstmt.setInt(7, patient.getId());
            pstmt.executeUpdate();
        }
    }

    public void deletePatient(int id) throws SQLException {
        String sql = "DELETE FROM patients WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}

