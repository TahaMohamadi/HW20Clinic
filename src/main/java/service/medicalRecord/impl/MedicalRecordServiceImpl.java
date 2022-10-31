package service.medicalRecord.impl;

import base.service.impl.BaseServiceImpl;
import entity.MedicalRecord;
import entity.Patient;
import entity.UserAccount;
import repository.medicalRecord.MedicalRecordRepo;
import repository.medicalRecord.impl.MedicalRecordRepoImpl;
import service.medicalRecord.MedicalRecordService;
import util.Hibernate;

import java.util.Optional;

public class
MedicalRecordServiceImpl extends BaseServiceImpl<MedicalRecord, MedicalRecordRepo> implements MedicalRecordService {
    private MedicalRecordRepo medicalRecordRepo = new MedicalRecordRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager());

    public MedicalRecordServiceImpl(MedicalRecordRepo repository) {
        super(repository);
    }

    @Override
    public MedicalRecord findByPatient(Patient patient) {
        try{
            return medicalRecordRepo.findByPatient(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
