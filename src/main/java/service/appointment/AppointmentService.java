package service.appointment;

import base.service.BaseService;
import entity.Appointment;
import entity.Patient;

import java.util.List;

public interface AppointmentService extends BaseService<Appointment> {

    List<Appointment> findByPatient(Patient patient);
}
