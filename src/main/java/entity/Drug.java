package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Drug  extends BaseEntity {
    private String name;
    private int dose;
}
