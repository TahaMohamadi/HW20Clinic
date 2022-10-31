package repository.patient;

import base.repository.BaseRepository;
import entity.MedicalRecord;
import entity.Patient;
import entity.UserAccount;

public interface PatientRepo extends BaseRepository<Patient> {
    Patient findByUserAccount(UserAccount userAccount);

    Patient findByMedicalRecord(MedicalRecord medicalRecord);
}
