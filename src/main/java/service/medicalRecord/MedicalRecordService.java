package service.medicalRecord;

import base.service.BaseService;
import entity.MedicalRecord;
import entity.Patient;

public interface MedicalRecordService extends BaseService<MedicalRecord> {
    MedicalRecord findByPatient(Patient patient);
}
