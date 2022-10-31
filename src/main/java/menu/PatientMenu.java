package menu;

import entity.UserAccount;
import operation.ClinicOperation;
import operation.MedicalRecordOperation;

import java.util.Objects;
import java.util.Scanner;

public class PatientMenu {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu(UserAccount user) {
        while (true) {
            System.out.println("Welcome "+ user.getUsername());
            System.out.println("please select your service number");
            System.out.println("1- show clinics");
            System.out.println("2- show medical record");
            System.out.println("3- settings");
            System.out.println("4- Exit");
            System.out.print("Enter your command: ");
            String patientCommand = scanner.next();
            if (Objects.equals(patientCommand, "1")) {
                ClinicMenu clinicMenu = new ClinicMenu();
                clinicMenu.showAll(user);
            } else if (Objects.equals(patientCommand, "2")) {
                MedicalRecordOperation medicalRecordOperation = new MedicalRecordOperation();
                medicalRecordOperation.showMedicalRecord(user);
            } else if ((Objects.equals(patientCommand, "3"))) {
                break;
            } else {
                System.out.println("Wrong command.");
            }

        }
    }

}
