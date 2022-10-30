package repository.patient.impl;

import base.repository.impl.BaseRepositoryImpl;
import base.service.impl.BaseServiceImpl;
import entity.Patient;
import jakarta.persistence.EntityManager;
import repository.patient.PatientRepo;

public class PatientRepoImpl extends BaseRepositoryImpl<Patient> implements PatientRepo {
    public PatientRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Patient> getEntityClass() {
        return Patient.class;
    }
}
