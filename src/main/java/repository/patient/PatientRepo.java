package repository.patient;

import base.repository.BaseRepository;
import entity.MedicalRecord;
import entity.Patient;
import entity.UserAccount;

import java.util.List;

public interface PatientRepo extends BaseRepository<Patient> {
    Patient findByUserAccount(UserAccount userAccount);

    Patient findByMedicalRecord(MedicalRecord medicalRecord);

    List<Patient> findAllPatient();

    Patient patientDesc(Long patientId);
}
