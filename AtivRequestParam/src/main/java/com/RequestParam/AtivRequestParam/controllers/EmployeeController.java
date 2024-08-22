package com.RequestParam.AtivRequestParam.controllers;

import com.RequestParam.AtivRequestParam.models.EmployeeModel;
import com.RequestParam.AtivRequestParam.models.enums.ActiveModel;
import com.RequestParam.AtivRequestParam.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeModel>> getAllEmployees
            (@RequestParam(value = "firstName", required = false) String firstName,
             @RequestParam(required = false) String department,
             @RequestParam(required = false) BigDecimal minSalary,
             @RequestParam(required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date hiredAfter,
             @RequestParam(required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date hiredBefore,
             @RequestParam(required = false) ActiveModel active){

        return ResponseEntity.status(HttpStatus.OK).body(
                employeeService.getAllEmployees(firstName, department, minSalary, hiredAfter, hiredBefore, active));
    }
}
