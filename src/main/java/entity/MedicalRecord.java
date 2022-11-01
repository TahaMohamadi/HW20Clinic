package entity;

import base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class MedicalRecord  extends BaseEntity {
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.MERGE)
    private List<Prescription> prescriptions = new ArrayList<>();
    @OneToMany(mappedBy = "medicalRecord", orphanRemoval = true, cascade = CascadeType.MERGE)
    private List<Appointment> appointments = new ArrayList<>();
}
