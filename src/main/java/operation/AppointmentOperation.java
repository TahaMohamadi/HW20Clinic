package operation;

import entity.*;
import enums.AppointmentType;
import menu.AppointmentMenu;
import menu.DoctorMenu;
import menu.PatientMenu;
import repository.appointment.impl.AppointmentRepoImpl;
import repository.medicalRecord.impl.MedicalRecordRepoImpl;
import repository.patient.impl.PatientRepoImpl;
import service.appointment.AppointmentService;
import service.appointment.impl.AppointmentServiceImpl;
import service.medicalRecord.MedicalRecordService;
import service.medicalRecord.impl.MedicalRecordServiceImpl;
import service.patient.PatientService;
import service.patient.impl.PatientServiceImpl;
import util.Hibernate;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;

public class AppointmentOperation {
    private final AppointmentService appointmentService = new AppointmentServiceImpl(new AppointmentRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final PatientService patientService = new PatientServiceImpl(new PatientRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final MedicalRecordService medicalRecordService = new MedicalRecordServiceImpl(new  MedicalRecordRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    public void showAll(MedicalRecord medicalRecord) {
        Patient patient = patientService.findByMedicalRecord(medicalRecord);
        List<Appointment> appointments = appointmentService.findByPatient(patient);
        appointments.forEach(appointment -> {
            System.out.println(appointment.getId() + "." + " doctor: " +appointment.getDoctor().getPerson().getFirstName() + " " + appointment.getDoctor().getPerson().getLastName());
            System.out.println("time from:" + appointment.getFromTime() + " to: " + appointment.getThruTime() +" in " +appointment.getDate());
        });
    }

//    public void showAll(MedicalRecord medicalRecord , Patient patient) {
//        List<MedicalRecord> medicalRecords = medicalRecordService.findByPatient(patient);
//        System.out.println("Your medicalRecord:");
//
//    }

    public void takeAppointment(Patient patient, Doctor doctor, int year, int month, int day, int hour, int minute, UserAccount userAccount, List<Doctor> doctors) {
        LocalTime time1 = LocalTime.of(hour,minute);
        System.out.println("your from time is: " + time1.toString());
        Time fromTime = Time.valueOf(time1);
        System.out.println("your from time is: " + fromTime.toString());

        minute = minute +30;
        if (minute>59){
            hour++;
            minute = minute - 60;
        }
        if (hour > 24){
            day++;
            hour = - 24;
        }
        if (day > 30){
            month++;
            day = -30;
        }
        if(month > 12){
            year++;
            month= -12;
        }

        LocalTime thruTimes = LocalTime.of(hour, minute);
        LocalDate dates = LocalDate.of(year, month, day);
        Time thruTime = Time.valueOf(thruTimes);
        Date date = Date.valueOf(dates);

        boolean check = appointmentService.checkAvailable(doctor, fromTime, thruTime, date);
        if (check) {
            Appointment appointment = new Appointment(patient, doctor, fromTime, thruTime, date, AppointmentType.WAITING);
            appointmentService.save(appointment);

            System.out.println("Your appointment is set!");
            PatientMenu patientMenu = new PatientMenu();
            patientMenu.showMenu(userAccount);
        } else {
            System.out.println("this time is not available, try again");
            AppointmentMenu appointment = new AppointmentMenu();
            appointment.showMenu(doctor.getId(), userAccount, doctors);
        }

    }

    public List<Appointment> showAllAppointment(Long doctorId) {
        List<Appointment> appointments= appointmentService.showAllAppointment(doctorId);
        return appointments;
    }

    public List<Appointment> showAllAppointments() {
        List<Appointment> appointments= appointmentService.showAllAppointments();
        return appointments;
    }
}



