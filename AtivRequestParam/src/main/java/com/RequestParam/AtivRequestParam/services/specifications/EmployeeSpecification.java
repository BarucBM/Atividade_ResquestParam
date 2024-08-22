package com.RequestParam.AtivRequestParam.services.specifications;

import com.RequestParam.AtivRequestParam.models.EmployeeModel;
import com.RequestParam.AtivRequestParam.models.enums.ActiveModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class EmployeeSpecification {
    public static Specification<EmployeeModel> hasFirstName(String firstName){
        return ((root, query, criteriaBuilder) -> {
            if (firstName != null)return criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%" + firstName.toLowerCase() +"%");
            else return null;
        });
    }

    public static Specification<EmployeeModel> hasDepartment(String department){
        return ((root, query, criteriaBuilder) ->
            department == null ? null: criteriaBuilder.like(criteriaBuilder.lower(root.get("department")), "%" + department.toLowerCase() + "%")
        );
    }

    public static Specification<EmployeeModel> hasSalaryMin(BigDecimal minSalary){
        return ((root, query, criteriaBuilder) -> {
            if (minSalary != null) return criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), minSalary);
            else return null;
        });
    }

    public static Specification<EmployeeModel> hasDateRange (Date hiredAfter, Date hiredBefore){
        return ((root, query, criteriaBuilder) -> {
            if(hiredAfter != null && hiredBefore != null) return criteriaBuilder.between(root.get("hireDate"), hiredAfter, hiredBefore);
            else if( hiredAfter != null)    return criteriaBuilder.greaterThan(root.get("hireDate"), hiredAfter);
            else if (hiredBefore != null)   return criteriaBuilder.lessThan(root.get("hireDate"), hiredBefore);
            else return null;
        });
    }

    public static Specification<EmployeeModel> hasActive(ActiveModel active){
        return ((root, query, criteriaBuilder) ->{
            if (Objects.isNull(active)) return null;
            else return criteriaBuilder.equal(root.get("active"), active);
        });

    }

}
