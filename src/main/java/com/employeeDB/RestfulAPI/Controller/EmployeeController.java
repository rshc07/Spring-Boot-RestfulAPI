package com.employeeDB.RestfulAPI.Controller;
import com.employeeDB.RestfulAPI.Repo.EmployeeRepository;
import com.employeeDB.RestfulAPI.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/displayAll";
    }

    @GetMapping("/displayAll")
    public String displayAll(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "displayAll";
    }

    @GetMapping("/display/{employeeId}")
    public String displayEmployee(@PathVariable String employeeId, Model model) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        model.addAttribute("employee", employee);
        return "displayEmployee";
    }
}