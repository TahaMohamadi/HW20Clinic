package operation;

import entity.*;
import repository.medicalRecord.impl.MedicalRecordRepoImpl;
import repository.patient.impl.PatientRepoImpl;
import repository.prescription.impl.PrescriptionRepoImpl;
import service.medicalRecord.MedicalRecordService;
import service.medicalRecord.impl.MedicalRecordServiceImpl;
import service.patient.PatientService;
import service.patient.impl.PatientServiceImpl;
import service.prescription.PrescriptionService;
import service.prescription.impl.PrescriptionServiceImpl;
import util.Hibernate;

import java.util.List;

public class PrescriptionOperation {
    private final PrescriptionService prescriptionService = new PrescriptionServiceImpl(new PrescriptionRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final PatientService patientService = new PatientServiceImpl(new PatientRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final MedicalRecordService medicalRecord = new MedicalRecordServiceImpl(new MedicalRecordRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));

    public void showAll(MedicalRecord medicalRecord) {
        Patient patient = patientService.findByMedicalRecord(medicalRecord);
        List<Prescription> prescriptions = prescriptionService.findByPatient(patient);
        prescriptions.forEach(prescription -> {
            System.out.println(prescription.getId() + ".");
            prescription.getDrugs().forEach(drug -> {
                System.out.println("drug name: "+ drug.getName() + " - dose: " + drug.getDose());
            });
        });
    }
}
