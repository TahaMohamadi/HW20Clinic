package repository.medicalRecord.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.MedicalRecord;
import jakarta.persistence.EntityManager;
import repository.medicalRecord.MedicalRecordRepo;

public class MedicalRecordImpl extends BaseRepositoryImpl<MedicalRecord> implements MedicalRecordRepo {
    public MedicalRecordImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<MedicalRecord> getEntityClass() {
        return MedicalRecord.class;
    }
}
