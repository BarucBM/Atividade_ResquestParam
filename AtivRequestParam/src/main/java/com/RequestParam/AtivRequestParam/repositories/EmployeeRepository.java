package com.RequestParam.AtivRequestParam.repositories;

import com.RequestParam.AtivRequestParam.models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>, JpaSpecificationExecutor<EmployeeModel> {
}
