package com.dcom.Order_Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcom.Order_Service.DTO.OrderLineItemDTO;
import com.dcom.Order_Service.DTO.OrderRequest;
import com.dcom.Order_Service.Model.Order;
import com.dcom.Order_Service.Model.OrderLineItem;
import com.dcom.Order_Service.Repository.OrderRepo;


@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderRepo orderRepo;

	public void placeOrder(OrderRequest orderRequest ) {
		
	List<OrderLineItem> orderLineItemList=	orderRequest.getOrderLineItemRequestList()
									.stream()
										.map(orderLineItemDTO->orderLineItemDtoToModel(orderLineItemDTO))
										.toList();
		
		Order order= Order.builder()
						.orderNumber(UUID.randomUUID().toString())
						.orderLineItemsList(orderLineItemList)
						.build();
		
		orderRepo.save(order);
		
		
	}
	
	
	public OrderLineItem orderLineItemDtoToModel(OrderLineItemDTO orderLineItemDTO) {
		
		return OrderLineItem.builder()
														.price(orderLineItemDTO.getPrice())
														.quantity(orderLineItemDTO.getQuantity())
														.skuCode(orderLineItemDTO.getSkuCode())
														.build();
	}
	
	
}
