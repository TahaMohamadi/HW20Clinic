package menu;

import entity.Appointment;
import entity.Drug;
import entity.Prescription;
import operation.DrugOperation;
import repository.appointment.impl.AppointmentRepoImpl;
import repository.prescription.impl.PrescriptionRepoImpl;
import service.appointment.AppointmentService;
import service.appointment.impl.AppointmentServiceImpl;
import service.prescription.PrescriptionService;
import service.prescription.impl.PrescriptionServiceImpl;
import util.Hibernate;

import java.util.List;
import java.util.Optional;

public class PrescriptionMenu {
//    private final Scanner scanner = new Scanner(System.in);
//    private final DrugService drugService = new DrugServiceImpl(new DrugRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
private final AppointmentService appointmentService = new AppointmentServiceImpl(new AppointmentRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
   private final PrescriptionService prescriptionService = new PrescriptionServiceImpl(new PrescriptionRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    DrugOperation drugOperation = new DrugOperation();
public void createPrescription(Long id) {

    Optional<Appointment> appointment = appointmentService.findById(id);
    List<Drug> drugs = drugOperation.getDrugList();

    Prescription prescription = new Prescription(drugs.stream().toList(),appointment.get().getPatient(), appointment.get().getMedicalRecord(), appointment.get().getDoctor());
    prescriptionService.save(prescription);
    }
}