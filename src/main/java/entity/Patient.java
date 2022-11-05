package entity;

import base.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Patient extends BaseEntity {
    @OneToOne(cascade = CascadeType.MERGE)
    private MedicalRecord medicalRecord;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;
}
