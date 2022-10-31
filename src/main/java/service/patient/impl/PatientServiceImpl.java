package service.patient.impl;

import base.service.impl.BaseServiceImpl;
import entity.MedicalRecord;
import entity.Patient;
import entity.UserAccount;
import repository.patient.PatientRepo;
import repository.patient.impl.PatientRepoImpl;
import service.patient.PatientService;
import util.Hibernate;

public class
PatientServiceImpl extends BaseServiceImpl<Patient, PatientRepo> implements PatientService {
        private PatientRepo patientRepo = new PatientRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager());

    public PatientServiceImpl(PatientRepo repository) {
        super(repository);
    }

    @Override
    public Patient findByUserAccount(UserAccount userAccount) {
        try{
            return patientRepo.findByUserAccount(userAccount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Patient findByMedicalRecord(MedicalRecord medicalRecord) {
        try{
            return patientRepo.findByMedicalRecord(medicalRecord);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
