package com.mylearning.docker.deployment.dockerpostgressdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

    //custom methods
    public List<Employee> findByLastName(String lastName);

    public List<Employee> findByFirstName(String firstName);

    public List<Employee> findByLastNameAndFirstName(String lastName, String firstName);

}
