package com.order_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order_service.client.UserClient;
import com.order_service.dto.OrderRequestDto;
import com.order_service.dto.OrderResponseDto;
import com.order_service.dto.UserResponseDto;
import com.order_service.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderService orderService;
	private final UserClient userClient;
	public OrderController(OrderService orderService, UserClient userClient) {
		super();
		this.orderService = orderService;
		this.userClient = userClient;
	}
@PostMapping()
public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderRequestDto){
	OrderResponseDto OrderResponseDto=orderService.createOrder(orderRequestDto);
	return OrderResponseDto;
}
@GetMapping("/{id}")
public OrderResponseDto getOrder(@PathVariable Long id) {
	return orderService.getOrderById(id);
}
@GetMapping()
public List<OrderResponseDto> getAllOrder() {
	return orderService.getAllOrders();
}

@GetMapping("/Ouser/{userId}")
@CircuitBreaker(
        name = "userServiceBreaker",
        fallbackMethod = "fallbackResponse"
)
public String getOrderDetails(
        @PathVariable Long userId) {

    UserResponseDto user =
            userClient.getUser(userId);

    return "Order belongs to user: "
            + user.getName();
}
//Fallback Method
public String fallbackResponse(
        Long userId,
        Exception ex) {

    return "User Service is currently unavailable. "
            + "Please try again later.";
	
}
}