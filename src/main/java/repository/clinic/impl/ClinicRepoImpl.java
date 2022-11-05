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
                select c from Clinic c order by c.name asc 
                """;
        return em.createQuery(jpql, Clinic.class).getResultList();
    }

    @Override
    public Clinic findClinicById(Long id) {
        String jpql = """
                select c from Clinic c where c.id = :id 
                """;
        return em.createQuery(jpql, Clinic.class).setParameter("id",id).getSingleResult();
    }


}

