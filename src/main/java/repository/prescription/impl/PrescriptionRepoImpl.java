package repository.prescription.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Prescription;
import jakarta.persistence.EntityManager;
import repository.prescription.PrescriptionRepo;

public class PrescriptionRepoImpl extends BaseRepositoryImpl<Prescription> implements PrescriptionRepo {
    public PrescriptionRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Prescription> getEntityClass() {
        return Prescription.class;
    }
}
