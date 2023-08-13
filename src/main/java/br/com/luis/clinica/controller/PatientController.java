package br.com.luis.clinica.controller;


import br.com.luis.clinica.domain.patient.PatientListData;
import br.com.luis.clinica.domain.patient.PatientRecordData;
import br.com.luis.clinica.domain.patient.PatientUpdateData;
import br.com.luis.clinica.model.Patient;
import br.com.luis.clinica.repositories.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientRepository repository;
    @PostMapping
    @Transactional
    public void registerPatient(@RequestBody PatientRecordData data) {

        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<PatientListData> listAllPatient(Pageable page) {

        return repository.findAll(page).map(PatientListData::new);
    }
    @GetMapping("/{id}")
    public Optional<Patient> listPatientId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping
    @Transactional
    public void updatePatient(@RequestBody @Valid PatientUpdateData data) {
        var patient = repository.getReferenceById(data.id());
        patient.infoUpdate(data);
    }
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
