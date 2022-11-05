package service.patient.impl;

import base.service.impl.BaseServiceImpl;
import entity.MedicalRecord;
import entity.Patient;
import entity.UserAccount;
import repository.patient.PatientRepo;
import repository.patient.impl.PatientRepoImpl;
import service.patient.PatientService;
import util.Hibernate;

import java.util.List;

public class
PatientServiceImpl extends BaseServiceImpl<Patient, PatientRepo> implements PatientService {

    public PatientServiceImpl(PatientRepo repository) {
        super(repository);
    }

    @Override
    public Patient findByUserAccount(UserAccount userAccount) {
        try{
            return repository.findByUserAccount(userAccount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Patient findByMedicalRecord(MedicalRecord medicalRecord) {
        try{
            return repository.findByMedicalRecord(medicalRecord);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Patient> findAllPatient() {
        try{
            return repository.findAllPatient();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void patientDesc(Long patientId) {
        try{
            return repository.patientDesc(patientId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
