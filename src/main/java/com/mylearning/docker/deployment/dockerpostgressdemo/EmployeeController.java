package com.mylearning.docker.deployment.dockerpostgressdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmpServiceImpl empService;

    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(empService.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/getEmployee")
    public ResponseEntity<List<Employee>> getEmployee() {
        return new ResponseEntity<>(empService.getAllEmployees(), HttpStatus.OK);
    }

}
