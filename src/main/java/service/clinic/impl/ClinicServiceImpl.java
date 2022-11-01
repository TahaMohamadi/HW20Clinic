package service.clinic.impl;

import base.service.impl.BaseServiceImpl;
import entity.Clinic;
import repository.clinic.ClinicRepo;
import service.clinic.ClinicService;

import java.util.List;

public class ClinicServiceImpl extends BaseServiceImpl<Clinic, ClinicRepo> implements ClinicService {

    public ClinicServiceImpl(ClinicRepo repository) {
        super(repository);
    }


    @Override
    public List<Clinic> findAllClinics() {
        try {
            return repository.findAllClinics();
        } catch (Exception e) {
            return null;
        }
    }
}