package com.example.clase5gtics.controller;

import com.example.clase5gtics.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("listaEmpPorRegion",employeeRepository.obtenerEmpleadosPorRegionDto());
        model.addAttribute("listaEmpPorPais",employeeRepository.obtenerEmpleadosPorPais());
        return "employee/estadistica";
    }
}
