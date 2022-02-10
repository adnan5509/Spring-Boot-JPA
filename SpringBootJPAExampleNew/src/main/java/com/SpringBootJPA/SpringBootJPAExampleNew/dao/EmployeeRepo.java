package com.SpringBootJPA.SpringBootJPAExampleNew.dao;

import com.SpringBootJPA.SpringBootJPAExampleNew.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    List<Employee> findByeDesignation(String employeeDesignation);

    List<Employee> findByeSalaryGreaterThan(double salaryGreaterThan);

    @Query("from Employee where E_DESIGNATION=?1 and E_SALARY < ?2")
    List<Employee> getEmployeesDueForRaise(String employeeRaiseDesignation, double employeeRaiseSalary);

}
