package repository.appointment;

import base.repository.BaseRepository;
import entity.Appointment;
import entity.Patient;

import java.util.List;

public interface AppointmentRepo extends BaseRepository<Appointment> {
    List<Appointment> findByPatient(Patient patient);
}
