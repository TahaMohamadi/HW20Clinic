package repository.drug.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Drug;
import jakarta.persistence.EntityManager;
import repository.drug.DrugRepo;
import util.Hibernate;

public class DrugRepoImpl extends BaseRepositoryImpl<Drug> implements DrugRepo {
    public DrugRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Drug> getEntityClass() {
        return Drug.class;
    }
    @Override
    public Drug findByName(String name) {
        String jpql = """
                select d from Drug d where d.name = :name 
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Drug.class).setParameter("name", name).getSingleResult());

    }
}
