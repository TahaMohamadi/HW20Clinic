package operation;

import entity.Clinic;
import repository.clinic.impl.ClinicRepoImpl;
import service.clinic.ClinicService;
import service.clinic.impl.ClinicServiceImpl;
import util.Hibernate;

import java.util.List;
import java.util.Optional;

public class ClinicOperation {

    private final ClinicService clinicService = new ClinicServiceImpl(new ClinicRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    public void showClinic(){
        List<Clinic> clinics = clinicService.findAllClinics();
//        System.out.println(clinics + "............ ");

        clinics.forEach(clinic -> {
//            System.out.println(clinic.toString()+".------- ");
            System.out.println(clinic.getId() + ". " + clinic.getName());
        });
    }


    public Clinic findByClinicId(Long id) {
        Clinic clinic = clinicService.findByClinicId(id);
        return clinic;

    }
}