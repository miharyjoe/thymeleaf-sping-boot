package com.gradle.prog4.service;


import com.gradle.prog4.controller.Employee;
import com.gradle.prog4.model.EmployeeEntity;
import com.gradle.prog4.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public List<EmployeeEntity> getAllEmployees(){
        return repository.findAll();
    }

    public EmployeeEntity addEmployee(EmployeeEntity toCreate){
        return repository.save(toCreate);
    }

    public EmployeeEntity showUserById(Long id){
        Optional<EmployeeEntity> employee = repository.findById(id);
        if(employee.isPresent()){
            EmployeeEntity result = employee.get();
            return result;
        }
        return new EmployeeEntity();
    }
}
