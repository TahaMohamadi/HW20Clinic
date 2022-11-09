package service.patient;

import base.service.BaseService;
import entity.MedicalRecord;
import entity.Patient;
import entity.UserAccount;

import java.util.List;

public interface PatientService extends BaseService<Patient> {
    Patient findByUserAccount(UserAccount userAccount);

    Patient findByMedicalRecord(MedicalRecord medicalRecord);

    List<Patient> findAllPatient();

    Patient patientDesc(Long patientId);
}
