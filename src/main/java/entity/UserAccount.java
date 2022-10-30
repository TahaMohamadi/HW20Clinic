package entity;

import enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "userAccount")
public class UserAccount extends Person{
    private String username;
    private String password;
    @Enumerated()
    private AccountType accountType;
}
