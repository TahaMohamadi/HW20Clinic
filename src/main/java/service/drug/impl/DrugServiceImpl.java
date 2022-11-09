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

    public DrugServiceImpl(DrugRepo repository) {
        super(repository);
    }
    @Override
    public Drug findByName(String name) {
        try{
            return repository.findByName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
