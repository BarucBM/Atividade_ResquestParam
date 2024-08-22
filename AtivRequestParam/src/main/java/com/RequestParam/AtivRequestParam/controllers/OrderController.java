package com.RequestParam.AtivRequestParam.controllers;

import com.RequestParam.AtivRequestParam.models.EmployeeModel;
import com.RequestParam.AtivRequestParam.models.OrderModel;
import com.RequestParam.AtivRequestParam.models.enums.ActiveModel;
import com.RequestParam.AtivRequestParam.models.enums.StatusModel;
import com.RequestParam.AtivRequestParam.services.EmployeeService;
import com.RequestParam.AtivRequestParam.services.OrderService;
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
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderModel>> getAllEmployees
            (@RequestParam(value = "orderNumber", required = false) String orderNumber,
             @RequestParam(value = "customerName", required = false) String customerName,
             @RequestParam(value = "startDate", required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
             @RequestParam(value = "endDate", required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
             @RequestParam(value = "status", required = false) StatusModel status,
             @RequestParam(value = "minAmount", required = false) BigDecimal minAmount,
             @RequestParam(value = "maxAmount", required = false) BigDecimal maxAmount){

        return ResponseEntity.status(HttpStatus.OK).body(
                orderService.getAllOrders(orderNumber, customerName, startDate, endDate, status, minAmount, maxAmount));
    }
}
