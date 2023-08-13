package br.com.luis.clinica.domain.employee;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedRecordData(
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
        Specialty specialty) {
}
