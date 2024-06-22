package com.dcom.Order_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcom.Order_Service.Model.Order;

public interface OrderRepo extends  JpaRepository<Order, Long> {

}
