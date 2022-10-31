package service.clinic.impl;

import base.service.impl.BaseServiceImpl;
import entity.Clinic;
import repository.clinic.ClinicRepo;
import repository.clinic.impl.ClinicRepoImpl;
import service.clinic.ClinicService;
import util.Hibernate;

public class ClinicServiceImpl extends BaseServiceImpl<Clinic, ClinicRepo> implements ClinicService {
    private final ClinicRepo clinicRepo = new ClinicRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager());

    public ClinicServiceImpl(ClinicRepo repository) {
        super(repository);
    }


}
