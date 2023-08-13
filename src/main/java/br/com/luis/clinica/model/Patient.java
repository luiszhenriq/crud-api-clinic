package br.com.luis.clinica.model;

import br.com.luis.clinica.address.Address;
import br.com.luis.clinica.domain.patient.PatientRecordData;
import br.com.luis.clinica.domain.patient.PatientUpdateData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Table(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String telephone;

    private Integer age;
    @Embedded
    private Address address;

    public Patient(PatientRecordData data) {
        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.age = data.age();
        this.address = new Address(data.address());
    }

    public void infoUpdate(PatientUpdateData data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.telephone() != null) {
            this.telephone = data.telephone();
        }
        if (data.age() != null) {
            this.age = data.age();
        }
        if (data.address() != null) {
            this.address.updateInfo(data.address());
        }

    }
}
