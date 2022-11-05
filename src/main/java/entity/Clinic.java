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
//@ToString
@Entity
public class Clinic  extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "clinic", cascade = CascadeType.MERGE)
    private List<Doctor> clinicList = new ArrayList<>();
    @ManyToOne
    private Hospital hospital;
}
