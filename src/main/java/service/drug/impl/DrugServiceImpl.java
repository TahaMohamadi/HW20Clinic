package service.drug.impl;

import base.service.impl.BaseServiceImpl;
import entity.Drug;
import repository.doctor.DoctorRepo;
import repository.doctor.Impl.DoctorRepoImpl;
import repository.drug.DrugRepo;
import repository.drug.impl.DrugRepoImpl;
import service.drug.DrugService;
import util.Hibernate;

public class DrugServiceImpl extends BaseServiceImpl<Drug, DrugRepo> implements DrugService {
    private final DrugRepo doctorRepo = new DrugRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager());

    public DrugServiceImpl(DrugRepo repository) {
        super(repository);
    }
}
