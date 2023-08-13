package br.com.luis.clinica.domain.patient;

import br.com.luis.clinica.address.Address;
import br.com.luis.clinica.model.Patient;

public record PatientListData(Long id, String name, String email, String telephone, Integer age, Address address) {

    public PatientListData(Patient patient) {
        this(patient.getId(),patient.getName(),patient.getEmail(),patient.getTelephone(),patient.getAge(),patient.getAddress());
    }
}
