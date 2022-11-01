package service.hospital.impl;

import base.service.impl.BaseServiceImpl;
import entity.Hospital;
import repository.drug.DrugRepo;
import repository.drug.impl.DrugRepoImpl;
import repository.hospital.HospitalRepo;
import repository.hospital.impl.HospitalRepoImpl;
import service.hospital.HospitalService;
import util.Hibernate;

public class HospitalServiceImpl extends BaseServiceImpl<Hospital, HospitalRepo> implements HospitalService {

    public HospitalServiceImpl(HospitalRepo repository) {
        super(repository);
    }
}
