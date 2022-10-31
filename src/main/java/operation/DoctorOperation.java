package operation;

import entity.*;
import repository.clinic.impl.ClinicRepoImpl;
import repository.doctor.Impl.DoctorRepoImpl;
import service.clinic.ClinicService;
import service.clinic.impl.ClinicServiceImpl;
import service.doctor.DoctorService;
import service.doctor.impl.DoctorServiceImpl;
import util.Hibernate;

import java.util.List;
import java.util.Optional;

public class DoctorOperation {
    private final ClinicService clinicService = new ClinicServiceImpl(new ClinicRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final DoctorService doctorService = new DoctorServiceImpl(new DoctorRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    public void findByClinic(Long id) {
    }

    public List<Doctor> findByClinicId(Long id) {
        Optional<Clinic> optionalClinic = clinicService.findById(id);
        List<Doctor> doctors = null;
        optionalClinic.ifPresent(clinic -> {
            doctors.addAll(doctorService.findByClinic(clinic));

        });
        return doctors;

    }
}
