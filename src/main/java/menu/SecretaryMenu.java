package menu;

import entity.Doctor;
import entity.UserAccount;
import operation.Validation;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SecretaryMenu {
    Scanner scanner = new Scanner(System.in);
    public void showMenu(UserAccount user) {
        while (true) {
            System.out.println("welcome to Maktab system");
            System.out.println("choose a service: ");
            System.out.println("1. show clinics ");
            System.out.println("2. show doctors ");
            System.out.println("3. show patients ");
            System.out.println("4. show appointments ");
            System.out.println("5. Exit ");
            System.out.print("------- Enter command: ");
            String command = scanner.next();
            if (Objects.equals(command, "2")) {
                DoctorMenu doctorMenu = new DoctorMenu();
                doctorMenu.showAllDoctors();
            } else if (Objects.equals(command, "1")) {
                ClinicMenu clinicMenu = new ClinicMenu();
                clinicMenu.showAll(user);
            } else if ((Objects.equals(command, "3"))) {
                PatientMenu patientMenu = new PatientMenu();
                patientMenu.showAllPatient();
            } else if ((Objects.equals(command, "4"))) {
                AppointmentMenu appointmentMenu = new AppointmentMenu();
                appointmentMenu.showAllAppointments();

            } else if ((Objects.equals(command, "5"))) {
                break;

        } else {
                System.out.println("Wrong command.");
            }

        }



    }
}


