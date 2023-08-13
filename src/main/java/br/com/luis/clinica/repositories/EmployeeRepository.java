package br.com.luis.clinica.repositories;

import br.com.luis.clinica.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
