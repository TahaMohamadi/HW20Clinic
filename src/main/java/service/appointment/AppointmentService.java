package service.appointment;

import base.service.BaseService;
import entity.Appointment;
import entity.Doctor;
import entity.Patient;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface AppointmentService extends BaseService<Appointment> {

    List<Appointment> findByPatient(Patient patient);


    boolean checkAvailable(Doctor doctor, Time fromTime, Time thruTime, Date date);

    List<Appointment> showAllAppointment(Long doctorId);

    List<Appointment> showAllAppointments();

    List<Appointment> finByDoctor(Doctor doctor);
}
