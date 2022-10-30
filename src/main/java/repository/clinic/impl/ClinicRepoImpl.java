package repository.clinic.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Clinic;
import jakarta.persistence.EntityManager;
import repository.clinic.ClinicRepo;

public class ClinicRepoImpl extends BaseRepositoryImpl<Clinic> implements ClinicRepo {
    public ClinicRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Clinic> getEntityClass() {
        return Clinic.class;
    }
}
