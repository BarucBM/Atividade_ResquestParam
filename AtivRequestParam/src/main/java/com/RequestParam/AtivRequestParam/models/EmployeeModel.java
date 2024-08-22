package com.RequestParam.AtivRequestParam.models;

import com.RequestParam.AtivRequestParam.models.enums.ActiveModel;
import com.RequestParam.AtivRequestParam.models.enums.PositionModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private PositionModel position;

    private BigDecimal salary;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date hireDate;

    private String department;

    @Enumerated(EnumType.STRING)
    private ActiveModel active;


}
