package com.RequestParam.AtivRequestParam.models;

import com.RequestParam.AtivRequestParam.models.enums.StatusModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;

    private String customerName;

    @Enumerated(EnumType.STRING)
    private StatusModel status;

    private BigDecimal totalAmount;

    private Date orderDate;

}
