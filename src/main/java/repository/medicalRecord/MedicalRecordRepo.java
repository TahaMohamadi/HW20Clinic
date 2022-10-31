package repository.medicalRecord;

import base.repository.BaseRepository;
import entity.MedicalRecord;
import entity.Patient;

public interface MedicalRecordRepo extends BaseRepository<MedicalRecord> {
    MedicalRecord findByPatient(Patient patient);
}
