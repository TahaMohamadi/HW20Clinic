package repository.doctor.Impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Doctor;
import jakarta.persistence.EntityManager;
import repository.doctor.DoctorRepo;

public class DoctorRepoImpl extends BaseRepositoryImpl<Doctor> implements DoctorRepo {
    public DoctorRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Doctor> getEntityClass() {
        return Doctor.class;
    }
}
