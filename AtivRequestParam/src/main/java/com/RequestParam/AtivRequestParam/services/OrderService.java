package com.RequestParam.AtivRequestParam.services;

import com.RequestParam.AtivRequestParam.models.EmployeeModel;
import com.RequestParam.AtivRequestParam.models.OrderModel;
import com.RequestParam.AtivRequestParam.models.enums.ActiveModel;
import com.RequestParam.AtivRequestParam.models.enums.StatusModel;
import com.RequestParam.AtivRequestParam.repositories.OrderRepository;
import com.RequestParam.AtivRequestParam.services.specifications.EmployeeSpecification;
import com.RequestParam.AtivRequestParam.services.specifications.OrderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderModel> getAllOrders
            (String orderNumber, String customerName, Date startDate,
             Date endDate, StatusModel status, BigDecimal minAmount, BigDecimal maxAmount){
        Specification<OrderModel> spec = Specification
                .where(OrderSpecification.hasOrderNumber(orderNumber))
                .and(OrderSpecification.hasCustomerName(customerName))
                .and(OrderSpecification.hasDateRange(startDate,endDate))
                .and(OrderSpecification.hasStatus(status))
                .and(OrderSpecification.hasAmountRange(minAmount, maxAmount));

        return orderRepository.findAll(spec);

    }
}
