package repository.clinic.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Clinic;
import jakarta.persistence.EntityManager;
import repository.clinic.ClinicRepo;

import java.util.List;

public class ClinicRepoImpl extends BaseRepositoryImpl<Clinic> implements ClinicRepo {
    public ClinicRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Clinic> getEntityClass() {
        return Clinic.class;
    }



    public List<Clinic> findAllClinics() {
        String jpql = """
                select t from Clinic t order by t.name asc 
                """;
        return em.createQuery(jpql, Clinic.class).getResultList();
    }
    }

