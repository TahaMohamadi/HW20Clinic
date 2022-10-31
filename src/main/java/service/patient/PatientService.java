package service.patient;

import base.service.BaseService;
import entity.MedicalRecord;
import entity.Patient;
import entity.UserAccount;

public interface PatientService extends BaseService<Patient> {
    Patient findByUserAccount(UserAccount userAccount);

    Patient findByMedicalRecord(MedicalRecord medicalRecord);
}
