package repository.doctor;

import base.repository.BaseRepository;
import entity.Clinic;
import entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorRepo extends BaseRepository<Doctor> {
    static void findByPatient(Clinic clinic) {
    }


    List<Doctor> findByClinic(Clinic clinic);

    Doctor findDoctorById(Long id);

    List<Doctor> findAllDoctor();
}
