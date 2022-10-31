package menu;

import entity.Appointment;
import entity.Doctor;
import entity.Patient;
import entity.UserAccount;
import enums.AppointmentType;
import repository.appointment.impl.AppointmentRepoImpl;
import repository.doctor.Impl.DoctorRepoImpl;
import repository.patient.impl.PatientRepoImpl;
import service.appointment.AppointmentService;
import service.appointment.impl.AppointmentServiceImpl;
import service.doctor.DoctorService;
import service.doctor.impl.DoctorServiceImpl;
import service.patient.PatientService;
import service.patient.impl.PatientServiceImpl;
import util.Hibernate;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class DoctorMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final DoctorService doctorService = new DoctorServiceImpl(new DoctorRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final PatientService patientService = new PatientServiceImpl(new PatientRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final AppointmentService appointmentService = new AppointmentServiceImpl(new AppointmentRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    public void showMenu(List<Doctor> doctors, UserAccount userAccount) {
        while (true) {
            System.out.println("choose your doctor's code for take an Appointment: ");
            AtomicInteger i = new AtomicInteger(1);
            doctors.forEach(doctor -> {

                System.out.println( i.getAndAdd(1) + ". " + doctor.getPerson().getFirstName() +" "+ doctor.getPerson().getLastName() + "  ->  " + doctor.getSpeciality() + "   code: " + doctor.getId());
            });
            Long id = scanner.nextLong();
            AppointmentMenu appointmentMenu = new AppointmentMenu();
            appointmentMenu.showMenu(id, userAccount);
        }
    }

    private void takeAppointment(Long id, UserAccount userAccount){
        Doctor doctor = doctorService.findById(id).get();
        Patient patient = patientService.findById(userAccount.getId()).get();
        // doesn't have validation
        while (true) {
            System.out.println("choose your year: ");
            int year = scanner.nextInt();
            System.out.println("choose your month: ");
            int month = scanner.nextInt();
            System.out.println("choose your day: ");
            int day = scanner.nextInt();
            Date date = new Date(year, month - 1, day);
            System.out.println("choose your day: ");
            System.out.println("choose your start time: ");
            System.out.println("hour: ");
            int hour = scanner.nextInt();
            System.out.println("minute: ");
            int minute = scanner.nextInt();
            Time fromTime = new Time(hour, minute, 0);
            System.out.println("choose your end time: ");
            System.out.println("hour: ");
            hour = scanner.nextInt();
            System.out.println("minute: ");
            minute = scanner.nextInt();
            Time thruTime = new Time(hour, minute, 0);
            boolean check = appointmentService.checkAvailable(doctor, fromTime, thruTime, date, patient);
            if (check) {
                Appointment appointment = new Appointment(patient, doctor, fromTime, thruTime, date, AppointmentType.WAITING);
                System.out.println("Your appointment is set!");
                PatientMenu patientMenu = new PatientMenu();
                patientMenu.showMenu(userAccount);
            } else {
                System.out.println("this time is not available, try again");
            }
        }
    }

    public void showDoctorMenu(UserAccount user) {
    }


}

