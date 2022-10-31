package operation;

import entity.Clinic;
import entity.MedicalRecord;
import entity.Patient;
import entity.Prescription;
import repository.clinic.impl.ClinicRepoImpl;
import repository.doctor.Impl.DoctorRepoImpl;
import repository.medicalRecord.impl.MedicalRecordRepoImpl;
import repository.patient.impl.PatientRepoImpl;
import repository.prescription.impl.PrescriptionRepoImpl;
import service.clinic.ClinicService;
import service.clinic.impl.ClinicServiceImpl;
import service.doctor.DoctorService;
import service.doctor.impl.DoctorServiceImpl;
import service.medicalRecord.MedicalRecordService;
import service.medicalRecord.impl.MedicalRecordServiceImpl;
import service.patient.PatientService;
import service.patient.impl.PatientServiceImpl;
import service.prescription.PrescriptionService;
import service.prescription.impl.PrescriptionServiceImpl;
import util.Hibernate;

import java.util.List;
import java.util.Optional;

public class DoctorOperation {
    private final ClinicService clinicService = new ClinicServiceImpl(new ClinicRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final DoctorService doctorService = new DoctorServiceImpl(new DoctorRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    public void findByClinic(Long id) {
    }

    public void findByClinicId(Long id) {
        Optional<Clinic> optionalClinic = clinicService.findById(id);

        optionalClinic.ifPresent(clinic -> {
            doctorService.findByClinic(clinic);

        });
    }
}
