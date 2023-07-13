package com.gradle.prog4.controller;



import com.gradle.prog4.controller.mapper.EmployeeMapper;
import com.gradle.prog4.model.EmployeeEntity;
import com.gradle.prog4.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/")
@AllArgsConstructor
@CrossOrigin
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper mapper;

    @GetMapping("/employee/list")
    public String showEmployees(Model model) {
        List<EmployeeEntity> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
            return "employee_list";
    }

    @GetMapping("/employee/new")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "form_employee";
    }
    @PostMapping("/employee/add")
    public String saveEmployee(@RequestParam("image") MultipartFile imageFile, Employee employee) throws IOException {
        employeeService.addEmployee(mapper.toRest(employee));
        return "redirect:/employee/list";
    }

    @GetMapping("/employee/about")
    public String about(@RequestParam("id") Long id, Model model){
        EmployeeEntity employee = employeeService.showUserById(id);
        model.addAttribute("employee", employee);
        return "about";
    }
}
