package HospitalManagementSystem;

import java.sql.*;

public class AppointmentDAO {
    public void bookAppointment(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_date, appointment_time) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointment.getPatientId());
            pstmt.setInt(2, appointment.getDoctorId());
            pstmt.setDate(3, Date.valueOf(appointment.getAppointmentDate()));
            pstmt.setTime(4, Time.valueOf(appointment.getAppointmentTime()));
            pstmt.executeUpdate();
        }
    }

    public void viewAppointments() throws SQLException {
        String sql = "SELECT * FROM appointments";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Appointment ID: " + rs.getInt("id"));
                System.out.println("Patient ID: " + rs.getInt("patient_id"));
                System.out.println("Doctor ID: " + rs.getInt("doctor_id"));
                System.out.println("Date: " + rs.getDate("appointment_date"));
                System.out.println("Time: " + rs.getTime("appointment_time"));
                System.out.println();
            }
        }
    }

    public void updateAppointment(Appointment appointment) throws SQLException {
        String sql = "UPDATE appointments SET patient_id = ?, doctor_id = ?, appointment_date = ?, appointment_time = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointment.getPatientId());
            pstmt.setInt(2, appointment.getDoctorId());
            pstmt.setDate(3, Date.valueOf(appointment.getAppointmentDate()));
            pstmt.setTime(4, Time.valueOf(appointment.getAppointmentTime()));
            pstmt.setInt(5, appointment.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteAppointment(int id) throws SQLException {
        String sql = "DELETE FROM appointments WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
