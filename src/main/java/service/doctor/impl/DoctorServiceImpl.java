package service.doctor.impl;

import base.service.impl.BaseServiceImpl;
import entity.Clinic;
import entity.Doctor;
import repository.doctor.DoctorRepo;
import service.doctor.DoctorService;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Doctor findDoctorById(Long id) {
        try{
            return repository.findDoctorById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Doctor> findAllDoctor() {
        try{
            return repository.findAllDoctor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }      }
}
