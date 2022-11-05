package entity;


import base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Entity
public class Doctor extends BaseEntity {
    @OneToOne
    private UserAccount userAccount;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn
    private Clinic clinic;
    private boolean isAvailable;
    private String speciality;
    @OneToOne(orphanRemoval = true)
    private Person person;
}
