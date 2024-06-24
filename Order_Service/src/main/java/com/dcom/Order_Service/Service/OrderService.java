package com.dcom.Order_Service.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.dcom.Order_Service.DTO.InventoryResponse;
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

//	@Autowired
//	WebClient webClient ;

	@Autowired
	WebClient.Builder webClientBuilder ;

	
	public boolean placeOrder(OrderRequest orderRequest) throws IllegalAccessException {

		List<OrderLineItem> orderLineItemList = orderRequest.getOrderLineItemRequestList().stream()
				.map(orderLineItemDTO -> orderLineItemDtoToModel(orderLineItemDTO)).toList();

		Order order = Order.builder().orderNumber(UUID.randomUUID().toString()).orderLineItemsList(orderLineItemList)
				.build();
		
		

		List<String> skuCodeList = orderRequest.getOrderLineItemRequestList().stream()
				.map(orderLineItem -> orderLineItem.getSkuCode()).toList();
		

		 InventoryResponse[] temp= inventoryResponseArray(skuCodeList);
		
		Arrays.stream(inventoryResponseArray(skuCodeList)).forEach(invRes-> System.err.println("Name: "
						+invRes.getSkuCode()+" Present:"+invRes.isInStock()));

		boolean allProductsAreInStock = Arrays.stream(inventoryResponseArray(skuCodeList))
				.allMatch(invenventoryResponse -> invenventoryResponse.isInStock()==true);

		if (allProductsAreInStock) {
			orderRepo.save(order);
			return true;
		} else {
			throw new IllegalAccessException("Product is not in Stock!");
		}

	}

	public OrderLineItem orderLineItemDtoToModel(OrderLineItemDTO orderLineItemDTO) {

		return OrderLineItem.builder().price(orderLineItemDTO.getPrice()).quantity(orderLineItemDTO.getQuantity())
				.skuCode(orderLineItemDTO.getSkuCode()).build();
	}

	//not using this function
//	public boolean isSkuInStock(String skuCode) {
//
//		return webClient.get().uri("http://localhost:8083/api/inventory/" + skuCode).retrieve().bodyToMono(Boolean.class)
//				.block();
//	}

	public InventoryResponse[] inventoryResponseArray(List<String> skuCodeList) {

		System.err.println("Calling...");
		
		//return webClient.get()
		return webClientBuilder.build().get()
				//.uri("http://localhost:8083/api/inventory?skuCodes="+skuCodeList.get(0))
				//.uri("http://localhost:8083/api/inventory", 
				.uri("http://InventoryService/api/inventory", 
						uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodeList).build())
				.retrieve()
				.bodyToMono(InventoryResponse[].class)
				.block();
	}

}
