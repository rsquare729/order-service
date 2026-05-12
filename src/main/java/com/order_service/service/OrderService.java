package com.order_service.service;

import java.util.List;

import com.order_service.dto.OrderRequestDto;
import com.order_service.dto.OrderResponseDto;

public interface OrderService {
	public OrderResponseDto createOrder(OrderRequestDto orderRequestDto);
	public OrderResponseDto getOrderById(Long id);
	public List<OrderResponseDto> getAllOrders();
}
