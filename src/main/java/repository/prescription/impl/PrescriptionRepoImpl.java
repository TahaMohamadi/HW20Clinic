package repository.prescription.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Patient;
import entity.Prescription;
import jakarta.persistence.EntityManager;
import repository.prescription.PrescriptionRepo;
import util.Hibernate;

import java.util.List;
import java.util.Optional;

public class PrescriptionRepoImpl extends BaseRepositoryImpl<Prescription> implements PrescriptionRepo {
    public PrescriptionRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Prescription> getEntityClass() {
        return Prescription.class;
    }

    @Override
    public List<Prescription> findByPatient(Patient patient) {
        String jpql = """
                select p from Prescription p where p.patient = :patient
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Prescription.class).setParameter("patient", patient).getResultList());
    }
}
