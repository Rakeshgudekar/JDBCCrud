package HospitalManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        while (true) {
            System.out.println("Hospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Add Doctor");
            System.out.println("6. View Doctors");
            System.out.println("7. Update Doctor");
            System.out.println("8. Delete Doctor");
            System.out.println("9. Book Appointment");
            System.out.println("10. View Appointments");
            System.out.println("11. Update Appointment");
            System.out.println("12. Delete Appointment");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        Patient patient = new Patient();
                        System.out.print("Enter first name: ");
                        patient.setFirstName(scanner.nextLine());
                        System.out.print("Enter last name: ");
                        patient.setLastName(scanner.nextLine());
                        System.out.print("Enter date of birth (YYYY-MM-DD): ");
                        patient.setDob(scanner.nextLine());
                        System.out.print("Enter gender (Male/Female/Other): ");
                        patient.setGender(scanner.nextLine());
                        System.out.print("Enter contact number: ");
                        patient.setContactNumber(scanner.nextLine());
                        System.out.print("Enter address: ");
                        patient.setAddress(scanner.nextLine());
                        patientDAO.addPatient(patient);
                        System.out.println("Patient added successfully.");
                        break;
                    case 2:
                        patientDAO.viewPatients();
                        break;
                    case 3:
                        patient = new Patient();
                        System.out.print("Enter patient ID to update: ");
                        patient.setId(scanner.nextInt());
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter first name: ");
                        patient.setFirstName(scanner.nextLine());
                        System.out.print("Enter last name: ");
                        patient.setLastName(scanner.nextLine());
                        System.out.print("Enter date of birth (YYYY-MM-DD): ");
                        patient.setDob(scanner.nextLine());
                        System.out.print("Enter gender (Male/Female/Other): ");
                        patient.setGender(scanner.nextLine());
                        System.out.print("Enter contact number: ");
                        patient.setContactNumber(scanner.nextLine());
                        System.out.print("Enter address: ");
                        patient.setAddress(scanner.nextLine());
                        patientDAO.updatePatient(patient);
                        System.out.println("Patient updated successfully.");
                        break;
                    case 4:
                        System.out.print("Enter patient ID to delete: ");
                        int patientId = scanner.nextInt();
                        patientDAO.deletePatient(patientId);
                        System.out.println("Patient deleted successfully.");
                        break;
                    case 5:
                        Doctor doctor = new Doctor();
                        System.out.print("Enter first name: ");
                        doctor.setFirstName(scanner.nextLine());
                        System.out.print("Enter last name: ");
                        doctor.setLastName(scanner.nextLine());
                        System.out.print("Enter specialty: ");
                        doctor.setSpecialty(scanner.nextLine());
                        System.out.print("Enter contact number: ");
                        doctor.setContactNumber(scanner.nextLine());
                        System.out.print("Enter email: ");
                        doctor.setEmail(scanner.nextLine());
                        doctorDAO.addDoctor(doctor);
                        System.out.println("Doctor added successfully.");
                        break;
                    case 6:
                        doctorDAO.viewDoctors();
                        break;
                    case 7:
                        doctor = new Doctor();
                        System.out.print("Enter doctor ID to update: ");
                        doctor.setId(scanner.nextInt());
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter first name: ");
                        doctor.setFirstName(scanner.nextLine());
                        System.out.print("Enter last name: ");
                        doctor.setLastName(scanner.nextLine());
                        System.out.print("Enter specialty: ");
                        doctor.setSpecialty(scanner.nextLine());
                        System.out.print("Enter contact number: ");
                        doctor.setContactNumber(scanner.nextLine());
                        System.out.print("Enter email: ");
                        doctor.setEmail(scanner.nextLine());
                        doctorDAO.updateDoctor(doctor);
                        System.out.println("Doctor updated successfully.");
                        break;
                    case 8:
                        System.out.print("Enter doctor ID to delete: ");
                        int doctorId = scanner.nextInt();
                        doctorDAO.deleteDoctor(doctorId);
                        System.out.println("Doctor deleted successfully.");
                        break;
                    case 9:
                        Appointment appointment = new Appointment();
                        System.out.print("Enter patient ID: ");
                        appointment.setPatientId(scanner.nextInt());
                        System.out.print("Enter doctor ID: ");
                        appointment.setDoctorId(scanner.nextInt());
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter appointment date (YYYY-MM-DD): ");
                        appointment.setAppointmentDate(scanner.nextLine());
                        System.out.print("Enter appointment time (HH:MM:SS): ");
                        appointment.setAppointmentTime(scanner.nextLine());
                        appointmentDAO.bookAppointment(appointment);
                        System.out.println("Appointment booked successfully.");
                        break;
                    case 10:
                        appointmentDAO.viewAppointments();
                        break;
                    case 11:
                        appointment = new Appointment();
                        System.out.print("Enter appointment ID to update: ");
                        appointment.setId(scanner.nextInt());
                        System.out.print("Enter patient ID: ");
                        appointment.setPatientId(scanner.nextInt());
                        System.out.print("Enter doctor ID: ");
                        appointment.setDoctorId(scanner.nextInt());
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter appointment date (YYYY-MM-DD): ");
                        appointment.setAppointmentDate(scanner.nextLine());
                        System.out.print("Enter appointment time (HH:MM:SS): ");
                        appointment.setAppointmentTime(scanner.nextLine());
                        appointmentDAO.updateAppointment(appointment);
                        System.out.println("Appointment updated successfully.");
                        break;
                    case 12:
                        System.out.print("Enter appointment ID to delete: ");
                        int appointmentId = scanner.nextInt();
                        appointmentDAO.deleteAppointment(appointmentId);
                        System.out.println("Appointment deleted successfully.");
                        break;
                    case 13:
                        System.out.println("Exited");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
