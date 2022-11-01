package service.doctor.impl;

import base.service.impl.BaseServiceImpl;
import entity.Clinic;
import entity.Doctor;
import repository.doctor.DoctorRepo;
import repository.doctor.Impl.DoctorRepoImpl;
import service.doctor.DoctorService;
import util.Hibernate;

import java.util.List;

public class DoctorServiceImpl extends BaseServiceImpl<Doctor, DoctorRepo> implements DoctorService {

    public DoctorServiceImpl(DoctorRepo repository) {
        super(repository);
    }


    @Override
    public List<Doctor> findByClinic(Clinic clinic) {
        try{
            return repository.findByClinic(clinic);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
