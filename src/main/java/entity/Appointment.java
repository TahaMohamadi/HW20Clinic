package entity;

import base.entity.BaseEntity;
import enums.AppointmentTime;
import enums.AppointmentType;
import enums.DayEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Appointment  extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private Time fromTime;
    private Time thruTime;
    private Date date;
    @Enumerated
    private AppointmentType status;
    @ManyToOne
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;

    public Appointment(Patient patient, Doctor doctor, Time fromTime, Time thruTime, Date date, AppointmentType status) {
        this.patient = patient;
        this.doctor = doctor;
        this.fromTime = fromTime;
        this.thruTime = thruTime;
        this.date = date;
        this.status = status;
    }
}





