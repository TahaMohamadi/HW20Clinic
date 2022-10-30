package repository.drug.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Drug;
import jakarta.persistence.EntityManager;
import repository.drug.DrugRepo;

public class DrugRepoImpl extends BaseRepositoryImpl<Drug> implements DrugRepo {
    public DrugRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Drug> getEntityClass() {
        return Drug.class;
    }
}
