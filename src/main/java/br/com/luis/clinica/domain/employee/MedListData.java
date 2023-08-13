package br.com.luis.clinica.domain.employee;

import br.com.luis.clinica.model.Employee;

public record MedListData(Long id, String name, String email, Integer age, Specialty specialty) {

    public MedListData(Employee employee) {
        this(employee.getId(),employee.getName(),employee.getEmail(),employee.getAge(),employee.getSpecialty());
    }
}
