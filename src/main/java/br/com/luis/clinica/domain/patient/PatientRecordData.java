package br.com.luis.clinica.domain.patient;

import br.com.luis.clinica.address.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PatientRecordData(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telephone,
        @NotNull
        Integer age,

        @NotNull
        @Valid
        Address address) {
}
