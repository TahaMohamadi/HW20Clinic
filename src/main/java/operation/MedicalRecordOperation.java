package operation;

import entity.MedicalRecord;
import entity.Patient;
import entity.UserAccount;
import menu.MedicalRecordMenu;
import repository.medicalRecord.impl.MedicalRecordRepoImpl;
import repository.patient.impl.PatientRepoImpl;
import service.medicalRecord.MedicalRecordService;
import service.medicalRecord.impl.MedicalRecordServiceImpl;
import service.patient.PatientService;
import service.patient.impl.PatientServiceImpl;
import util.Hibernate;

public class MedicalRecordOperation {
    private final MedicalRecordService medicalRecordService = new MedicalRecordServiceImpl(new MedicalRecordRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final PatientService patientService = new PatientServiceImpl(new PatientRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));

        public void showMedicalRecord(UserAccount userAccount) {
            Patient patient = patientService.findByUserAccount(userAccount);
            MedicalRecord medicalRecord = medicalRecordService.findByPatient(patient);
            MedicalRecordMenu medicalRecordMenu = new MedicalRecordMenu();
            medicalRecordMenu.showMenu(medicalRecord);
        }
    }


