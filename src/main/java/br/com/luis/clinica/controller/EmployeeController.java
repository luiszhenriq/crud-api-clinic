package br.com.luis.clinica.controller;



import br.com.luis.clinica.domain.employee.MedListData;
import br.com.luis.clinica.domain.employee.MedUpdateData;
import br.com.luis.clinica.model.Employee;
import br.com.luis.clinica.domain.employee.MedRecordData;
import br.com.luis.clinica.repositories.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @PostMapping
    @Transactional
    public void registerMed(@RequestBody @Valid MedRecordData data) {

        repository.save(new Employee(data));
    }
    @GetMapping
    public Page<MedListData> listAllMed(Pageable page) {

        return repository.findAll(page).map(MedListData::new);
    }
    @GetMapping("/{id}")
    public Optional<Employee> listMedId(@PathVariable Long id) {
        return repository.findById(id);
    }
    @PutMapping
    @Transactional
    public void updateMed(@RequestBody @Valid MedUpdateData data) {
        var employee = repository.getReferenceById(data.id());
        employee.infoUpdate(data);
    }
    @DeleteMapping("/{id}")
    public void deleteMed(@PathVariable Long id) {

        repository.deleteById(id);
    }
}
