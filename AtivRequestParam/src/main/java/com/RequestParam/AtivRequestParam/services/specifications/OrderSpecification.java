package com.RequestParam.AtivRequestParam.services.specifications;


import com.RequestParam.AtivRequestParam.models.OrderModel;

import com.RequestParam.AtivRequestParam.models.enums.StatusModel;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.Date;


public class OrderSpecification {
    public static Specification<OrderModel> hasOrderNumber(String orderNumber){
        return ((root, query, criteriaBuilder) -> {
            if (orderNumber != null)return criteriaBuilder
                    .like(criteriaBuilder.lower(root.get("orderNumber")), "%" + orderNumber.toLowerCase() +"%");
            else return null;
        });
    }

    public static Specification<OrderModel> hasCustomerName(String customerName){
        return ((root, query, criteriaBuilder) ->
                customerName == null ? null: criteriaBuilder
                        .like(criteriaBuilder.lower(root.get("customerName")), "%" + customerName.toLowerCase() + "%")
        );
    }

    public static Specification<OrderModel> hasStatus(StatusModel status){
        return ((root, query, criteriaBuilder) -> {
            if (status != null) return criteriaBuilder.equal(root.get("status"), status);
            else return null;
        });
    }

    public static Specification<OrderModel> hasAmountRange (BigDecimal minAmount, BigDecimal maxAmount){
        return ((root, query, criteriaBuilder) -> {
            if(minAmount != null && maxAmount != null) return criteriaBuilder.between(root.get("totalAmount"), minAmount, maxAmount);
            else if( minAmount != null)    return criteriaBuilder.greaterThan(root.get("totalAmount"), minAmount);
            else if (maxAmount != null)   return criteriaBuilder.lessThan(root.get("totalAmount"), maxAmount);
            else return null;
        });
    }

    public static Specification<OrderModel> hasDateRange (Date startDate, Date endDate){
        return ((root, query, criteriaBuilder) -> {
            if(startDate != null && endDate != null) return criteriaBuilder.between(root.get("orderDate"), startDate, endDate);
            else if( startDate != null)    return criteriaBuilder.greaterThan(root.get("orderDate"), startDate);
            else if (endDate != null)   return criteriaBuilder.lessThan(root.get("orderDate"), endDate);
            else return null;
        });
    }

}
