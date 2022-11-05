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
            repository.getEntityManager().getTransaction().begin();
            return repository.findAllClinics();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Clinic findByClinicId(Long id) {
        try {
            repository.getEntityManager().getTransaction().begin();
            return repository.findClinicById(id);
        } catch (Exception e) {
            return null;
        }
    }
}