package repository.doctor.Impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Clinic;
import entity.Doctor;
import jakarta.persistence.EntityManager;
import repository.doctor.DoctorRepo;
import util.Hibernate;

import java.util.List;
import java.util.Optional;

public class DoctorRepoImpl extends BaseRepositoryImpl<Doctor> implements DoctorRepo {
    public DoctorRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Doctor> getEntityClass() {
        return Doctor.class;
    }

    @Override
    public List<Doctor> findByClinic(Clinic clinic) {
        String jpql = """
                select d from Doctor d where d.clinic = :clinic
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Doctor.class).setParameter("clinic", clinic).getResultList());
    }

    @Override
    public Doctor findDoctorById(Long id) {
        String jpql = """
                select d from Doctor d where d.id = :id
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Doctor.class).setParameter("id", id).getSingleResult());
    }

    @Override
    public List<Doctor> findAllDoctor() {
        String jpql = """
                select d from Doctor d 
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Doctor.class).getResultList());
    }
}

