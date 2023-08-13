package br.com.luis.clinica.domain.employee;

import jakarta.validation.constraints.NotNull;

public record MedUpdateData(
        @NotNull
        Long id,

        String name,

        String telephone,

        Integer age) {
}
