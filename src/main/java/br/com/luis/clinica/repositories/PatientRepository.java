package br.com.luis.clinica.repositories;

import br.com.luis.clinica.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
