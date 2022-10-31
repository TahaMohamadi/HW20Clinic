package repository.prescription;

import base.repository.BaseRepository;
import entity.Patient;
import entity.Prescription;

import java.util.List;

public interface PrescriptionRepo extends BaseRepository<Prescription> {
    List<Prescription> findByPatient(Patient patient);
}
