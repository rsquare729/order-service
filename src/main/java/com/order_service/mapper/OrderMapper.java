package com.order_service.mapper;

import com.order_service.dto.OrderRequestDto;
import com.order_service.dto.OrderResponseDto;
import com.order_service.entity.Order;

public class OrderMapper {
	public static Order toEntity(OrderRequestDto orderRequestDto) {
		Order order = new Order();
		order.setId(null);
		order.setProductName(orderRequestDto.getProductName());
		order.setQuantity(orderRequestDto.getQuantity());
		order.setPrice(orderRequestDto.getPrice());
		order.setUserId(orderRequestDto.getUserId());
		return order;
	}
	public static OrderResponseDto toDto(Order order) {
		return new OrderResponseDto(order.getId(), order.getProductName(), order.getQuantity(), order.getPrice(), order.getUserId());
	}
}
