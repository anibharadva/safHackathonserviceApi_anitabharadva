package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Anita
 * 6/12/2019
 */
@Entity
@Table(name = "emp_master")
public class Employee {

    // TODO: Generate getters and setters...

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "emp_id")
    private int emp_id;

    @Column(name = "employee_name")
    private String employee_name;

    @Column(name = "employee_salary")
    private String employee_salary;


    @Column(name = "employee_age")
    private String employee_age;

    @Column(name = "profile_image")
    private String profile_image;

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(name = "date_created")
    private Timestamp dateCreated;


    public int getEmpId() {
        return emp_id;
    }

    public void setEmpId(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmployeeName() {
        return employee_name;
    }

    public void setEmployeeName(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployeeSalary() {
        return employee_salary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employee_salary = employeeSalary;
    }

    public String getEmployeeAge() {
        return employee_age;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employee_age = employeeAge;
    }

    public String getProfileImage() {
        return profile_image;
    }

    public void setProfileImage(String profileImage) {
        this.profile_image = profileImage;
    }


}
