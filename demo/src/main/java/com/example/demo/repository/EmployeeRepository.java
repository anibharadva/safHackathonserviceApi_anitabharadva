package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Anita
 * 6/12/2019
 */

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
