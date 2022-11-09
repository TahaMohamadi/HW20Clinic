package menu;

import entity.MedicalRecord;
import entity.Patient;
import entity.UserAccount;
import operation.AppointmentOperation;
import operation.PrescriptionOperation;
import operation.Validation;

import java.util.Objects;
import java.util.Scanner;

public class MedicalRecordMenu {
    private final Scanner scanner = new Scanner(System.in);
    public void showMenu(MedicalRecord medicalRecord, Patient patient) {
        while (true) {
            System.out.println("Welcome to your MedicalRecord");
            System.out.println("please select your service number");
            System.out.println("1- Appointment");
            System.out.println("2- Prescription");
            System.out.println("3- Exit");
            System.out.print("Enter command: ");
            String command = scanner.next();
            if (Objects.equals(command, "1")) {
                AppointmentOperation appointmentOperation = new AppointmentOperation();
                appointmentOperation.showAll(medicalRecord);
            } else if (Objects.equals(command, "2")) {
                PrescriptionOperation prescriptionOperation = new PrescriptionOperation();
                prescriptionOperation.showAll(medicalRecord);
            } else if ((Objects.equals(command, "3"))) {
                break;
            } else {
                break;
            }

        }
    }
}
