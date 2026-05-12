package com.order_service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.order_service.dto.OrderRequestDto;
import com.order_service.dto.OrderResponseDto;
import com.order_service.entity.Order;
import com.order_service.mapper.OrderMapper;
import com.order_service.repository.OrderRepository;

@Service
public class OrderServiceImp implements OrderService {
	
	private Logger logger = LoggerFactory.getLogger(OrderServiceImp.class);
	private OrderRepository orderRepository;
	public OrderServiceImp(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	@Override
	public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
		logger.info("Creating order for user ID: {}", orderRequestDto.getUserId());
		Order order=OrderMapper.toEntity(orderRequestDto);
		Order savedOrder=orderRepository.save(order);
		logger.info("Order created with ID: {}", savedOrder.getId());
		return OrderMapper.toDto(savedOrder);
	}

	@Override
	public OrderResponseDto getOrderById(Long id) {
		logger.info("Fetching order with ID: {}", id);
		Order order=orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order not found with ID: "+id));
		logger.info("Order found: {}", order.getProductName());
		return OrderMapper.toDto(order);
	}

	@Override
	public List<OrderResponseDto> getAllOrders() {
		logger.info("Fetching all orders");
		 List<Order> orders=orderRepository.findAll();
		 logger.info("Total orders found: {}", orders.size());
		 return orders.stream().map(OrderMapper::toDto).toList();
	}

}
