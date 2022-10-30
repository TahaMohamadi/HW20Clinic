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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @OneToMany(mappedBy = "medicalRecord")
    private List<Prescription> prescriptions = new ArrayList<>();
    @OneToMany(mappedBy = "medicalRecord", orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();
}
