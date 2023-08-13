package br.com.luis.clinica.model;

import br.com.luis.clinica.domain.employee.MedRecordData;
import br.com.luis.clinica.domain.employee.MedUpdateData;
import br.com.luis.clinica.domain.employee.Specialty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    private String telephone;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    public Employee(MedRecordData data) {
        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.age = data.age();
        this.specialty = data.specialty();
    }

    public void infoUpdate(MedUpdateData data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.telephone() != null) {
            this.telephone = data.telephone();
        }
        if (data.age() != null) {
            this.age = data.age();
        }
    }
}
