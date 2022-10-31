package operation;

import entity.*;
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

import java.util.List;

public class AppointmentOperation {
    private final AppointmentService appointmentService = new AppointmentServiceImpl(new AppointmentRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final PatientService patientService = new PatientServiceImpl(new PatientRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));

    public void showAll(MedicalRecord medicalRecord, Doctor doctor) {
        Patient patient = patientService.findByMedicalRecord(medicalRecord);
        List<Appointment> appointments = appointmentService.findByPatient(patient);
        appointments.forEach(appointment -> {
            System.out.println(appointment.getId() + "." + " doctor: " +appointment.getDoctor().getPerson().getFirstName() + " " + appointment.getDoctor().getPerson().getLastName());
            System.out.println("time from:" + appointment.getFromTime() + " to: " + appointment.getThruTime() +" in " +appointment.getDate());
        });
    }

    public void showAll(MedicalRecord medicalRecord) {
    }
}



