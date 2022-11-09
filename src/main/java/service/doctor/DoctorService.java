package service.doctor;

import base.service.BaseService;
import entity.Clinic;
import entity.Doctor;
import entity.UserAccount;

import java.util.List;
import java.util.Optional;


public interface DoctorService extends BaseService<Doctor> {

    List<Doctor> findByClinic(Clinic clinic);
    Doctor findDoctorById(Long id);

    List<Doctor> findAllDoctor();

    Doctor findByUserId(UserAccount user);
}
