package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Patient extends BaseEntity {
    @OneToOne
    private MedicalRecord medicalRecord;
    @OneToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;
}
