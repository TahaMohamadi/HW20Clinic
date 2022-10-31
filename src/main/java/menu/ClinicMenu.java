package menu;

import operation.AppointmentOperation;
import operation.ClinicOperation;
import operation.DoctorOperation;
import operation.PrescriptionOperation;

import java.util.Objects;
import java.util.Scanner;

public class ClinicMenu {
    private final Scanner scanner = new Scanner(System.in);
    public void showAll() {

        ClinicOperation clinicOperation = new ClinicOperation();
        DoctorOperation doctorOperation = new DoctorOperation();
            while(true){
            System.out.println("Available Clinics: ");
            System.out.println("please select a Clinic");
            clinicOperation.showClinic();
            System.out.print("enter clinic id for see doctors of that clinic: ");
            Long id = scanner.nextLong();
            doctorOperation.findByClinicId(id);
//            if (Objects.equals(command, "1")) {
//                AppointmentOperation appointmentOperation = new AppointmentOperation();
//                appointmentOperation.showAll(medicalRecord);
//            } else if (Objects.equals(command, "2")) {
//                PrescriptionOperation prescriptionOperation = new PrescriptionOperation();
//                prescriptionOperation.showAll(medicalRecord);
//            } else if ((Objects.equals(command, "3"))) {
//                break;
//            } else {
//                break;
//            }

        }
    }
}

