package service.doctor;

import base.service.BaseService;
import entity.Clinic;
import entity.Doctor;

import java.util.List;


public interface DoctorService extends BaseService<Doctor> {

    List<Doctor> findByClinic(Clinic clinic);
}
