package repository.hospital.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Hospital;
import jakarta.persistence.EntityManager;
import repository.hospital.HospitalRepo;

public class HospitalRepoImpl extends BaseRepositoryImpl<Hospital> implements HospitalRepo {
    public HospitalRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Hospital> getEntityClass() {
        return Hospital.class;
    }
}
