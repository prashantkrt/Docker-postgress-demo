package com.mylearning.docker.deployment.dockerpostgressdemo;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class EmpServiceImpl {
    private static final Logger log = Logger.getLogger(EmpServiceImpl.class.getName());

    @Autowired
    private EmpRepository empRepository;

    public String addEmployee(Employee emp) {
        Example<Employee> example = Example.of(emp);
        if (!empRepository.exists(example)) {
            empRepository.save(emp);
            return "Employee added successfully";
        }
        return "Employee already exists";
    }

    public Employee getEmpById(int id) {
        if (empRepository.existsById(id)) {
            return empRepository.findById(id).get();
        }
        log.info("No employee with id " + id + " not found");
        throw new EntityNotFoundException("Employee with id " + id + " not found");
    }

    public List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }

    public List<Employee> getAllEmployeesByFirstName(String name) {
        return empRepository.findByFirstName(name);
    }

}
