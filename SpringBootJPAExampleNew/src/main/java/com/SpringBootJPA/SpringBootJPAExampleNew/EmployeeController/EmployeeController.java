package com.SpringBootJPA.SpringBootJPAExampleNew.EmployeeController;

import com.SpringBootJPA.SpringBootJPAExampleNew.dao.EmployeeRepo;
import com.SpringBootJPA.SpringBootJPAExampleNew.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "home";
    }

    @RequestMapping("/getEmployee")
    public ModelAndView getEmployee(@RequestParam(name = "getEmployeeId") int employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElse(new Employee());
        ModelAndView mv = new ModelAndView();
        mv.addObject("employee", employee);
        mv.setViewName("EmployeeInfo");
        return mv;
    }

    @RequestMapping("/getEmployeeByDesignation")
    public ModelAndView getEmployeeByDesignation(@RequestParam(name = "employeeDesignation") String employeeDesignation) {
        List<Employee> employeeList = employeeRepo.findByeDesignation(employeeDesignation);
        ModelAndView mv = new ModelAndView();
        mv.addObject("employeeList", employeeList);
        mv.setViewName("AllEmployeesInfo");
        return mv;
    }

    @RequestMapping("/getEmployeeWithGreaterSalary")
    public ModelAndView getEmployeeByDesignation(@RequestParam(name = "salaryGreaterThan") double salaryGreaterThan) {
        List<Employee> employeeList = employeeRepo.findByeSalaryGreaterThan(salaryGreaterThan);
        ModelAndView mv = new ModelAndView();
        mv.addObject("employeeList", employeeList);
        mv.setViewName("AllEmployeesInfo");
        return mv;
    }

    @RequestMapping("/getEmployeesDueForRaise")
    public ModelAndView getEmployeesDueForRaise(@RequestParam(name = "employeeRaiseDesignation") String employeeRaiseDesignation, @RequestParam(name = "employeeRaiseSalary") double employeeRaiseSalary) {
        List<Employee> employeeList = employeeRepo.getEmployeesDueForRaise(employeeRaiseDesignation, employeeRaiseSalary);
        ModelAndView mv = new ModelAndView();
        mv.addObject("employeeList", employeeList);
        mv.setViewName("AllEmployeesInfo");
        return mv;
    }

    @RequestMapping("/getAllEmployee")
    public ModelAndView getAllEmployee() {
        List<Employee> employeeList = (List<Employee>) employeeRepo.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("employeeList", employeeList);
        mv.setViewName("AllEmployeesInfo");
        return mv;
    }

    @RequestMapping("/updateEmployeeSalary")
    public ModelAndView updateEmployee(@RequestParam(name = "updateEmployeeId") int employeeId, @RequestParam(name = "updatedSalary") double eSalary) {
        Employee employeefetched = employeeRepo.findById(employeeId).orElse(new Employee());
        employeefetched.seteSalary(eSalary);
        employeeRepo.save(employeefetched);
        ModelAndView mv = new ModelAndView();
        mv.addObject("employee", employeefetched);
        mv.setViewName("EmployeeInfo");
        return mv;
    }

    @RequestMapping(path = "/employees", produces = {"application/json"})
    @ResponseBody
    public List<Employee> getAllEmployeesRest() {
        List<Employee> employeeList = (List<Employee>) employeeRepo.findAll();
        return employeeList;
    }

    @RequestMapping("/employee/{eid}")
    @ResponseBody
    public Employee getEmployeeRest(@PathVariable("eid") int employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElse(new Employee());
        return employee;
    }

    @PostMapping(path = "/employee", consumes = {"application/json"})
    @ResponseBody
    public Employee saveEmployeeRest(@RequestBody Employee employee) {
        employeeRepo.save(employee);
        return employee;
    }


    @PutMapping(path = "/employee")
    @ResponseBody
    public Employee saveOrUpdateEmployeeRest(@RequestBody Employee employee) {
        employeeRepo.save(employee);
        return employee;
    }

    @DeleteMapping(path = "/employee/{eid}")
    @ResponseBody
    public String deleteEmployeeRest(@PathVariable("eid") int employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElse(null);
        if (employee == null) {
            return "Employee Not Found";
        }
        String employeeName = employee.getEname();
        employeeRepo.delete(employee);
        return employeeName + " Deleted";
    }

}
