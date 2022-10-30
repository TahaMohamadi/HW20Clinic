package repository.secretary.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Secretary;
import jakarta.persistence.EntityManager;
import repository.secretary.SecretaryRepo;

public class SecretaryRepoImpl extends BaseRepositoryImpl<Secretary> implements SecretaryRepo {

    public SecretaryRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Secretary> getEntityClass() {
        return Secretary.class;
    }
}
