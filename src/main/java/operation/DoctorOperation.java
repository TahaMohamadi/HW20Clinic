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
import java.util.concurrent.atomic.AtomicInteger;

public class DoctorOperation {
    private final ClinicService clinicService = new ClinicServiceImpl(new ClinicRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final DoctorService doctorService = new DoctorServiceImpl(new DoctorRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    ClinicOperation clinicOperation = new ClinicOperation();
    public void findByClinic(Long id) {
    }

    public List<Doctor> findByClinicId(Long id) {
            Clinic clinic = clinicOperation.findByClinicId(id);
            System.out.println(clinic);
            List<Doctor> doctors = doctorService.findByClinic(clinic);
            AtomicInteger a = new AtomicInteger(0);
            String clinicName = clinic.getName();
            String s = String.format(("----------------- clinic %S doctors -----------------"),clinicName);
            System.out.println(s);
            doctors.forEach(doctor -> {
                a.getAndIncrement();
                System.out.println(a +". "+ doctor.getPerson().getFirstName() + " "+ doctor.getPerson().getLastName() + "  -> id: " + doctor.getId());
            });


        return doctors;

    }
}
