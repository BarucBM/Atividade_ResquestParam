package com.RequestParam.AtivRequestParam.services;

import com.RequestParam.AtivRequestParam.models.EmployeeModel;
import com.RequestParam.AtivRequestParam.models.enums.ActiveModel;
import com.RequestParam.AtivRequestParam.repositories.EmployeeRepository;
import com.RequestParam.AtivRequestParam.services.specifications.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeModel> getAllEmployees
            (String firstName, String department, BigDecimal minSalary, Date hiredAfter, Date hiredBefore, ActiveModel active){
        Specification<EmployeeModel> spec = Specification
                .where(EmployeeSpecification.hasActive(active))
                .and(EmployeeSpecification.hasDepartment(department))
                .and(EmployeeSpecification.hasDateRange(hiredAfter,hiredBefore))
                .and(EmployeeSpecification.hasFirstName(firstName))
                .and(EmployeeSpecification.hasSalaryMin(minSalary));

        return employeeRepository.findAll(spec);

    }
}
