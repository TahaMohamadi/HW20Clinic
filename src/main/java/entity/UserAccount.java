package entity;

import base.entity.BaseEntity;
import enums.AccountType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class UserAccount extends BaseEntity {
    private String username;
    private String password;
    @Enumerated
    private AccountType accountType;
    @OneToOne(cascade = CascadeType.MERGE)
    private Person person;
}
