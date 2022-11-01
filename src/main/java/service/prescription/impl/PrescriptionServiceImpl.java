package service.prescription.impl;

import base.service.impl.BaseServiceImpl;
import entity.Patient;
import entity.Prescription;
import repository.patient.PatientRepo;
import repository.patient.impl.PatientRepoImpl;
import repository.prescription.PrescriptionRepo;
import repository.prescription.impl.PrescriptionRepoImpl;
import service.prescription.PrescriptionService;
import util.Hibernate;

import java.util.List;

public class
PrescriptionServiceImpl extends BaseServiceImpl<Prescription, PrescriptionRepo> implements PrescriptionService {

    public PrescriptionServiceImpl(PrescriptionRepo repository) {
        super(repository);
    }

    @Override
    public List<Prescription> findByPatient(Patient patient) {
        try{
            return repository.findByPatient(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
