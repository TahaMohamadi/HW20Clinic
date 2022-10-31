package service.prescription;

import base.service.BaseService;
import entity.Patient;
import entity.Prescription;

import java.util.List;

public interface PrescriptionService extends BaseService<Prescription> {
    List<Prescription> findByPatient(Patient patient);
}
