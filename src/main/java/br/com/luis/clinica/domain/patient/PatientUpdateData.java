package br.com.luis.clinica.domain.patient;

import br.com.luis.clinica.address.Address;
import jakarta.validation.constraints.NotNull;

public record PatientUpdateData(
        @NotNull
        Long id,
        String name, String telephone, Integer age, Address address) {
}
