package repository.medicalRecord.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.MedicalRecord;
import entity.Patient;
import entity.UserAccount;
import jakarta.persistence.EntityManager;
import repository.medicalRecord.MedicalRecordRepo;
import util.Hibernate;

import java.util.Optional;

public class MedicalRecordRepoImpl extends BaseRepositoryImpl<MedicalRecord> implements MedicalRecordRepo {
    public MedicalRecordRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<MedicalRecord> getEntityClass() {
        return MedicalRecord.class;
    }

    @Override
    public MedicalRecord findByPatient(Patient patient) {
        String jpql = """
                select m from MedicalRecord m where m.patient = :patient
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, MedicalRecord.class)
                .setParameter("patient", patient).getSingleResult());
            }
}


