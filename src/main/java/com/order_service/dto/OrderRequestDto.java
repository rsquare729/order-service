package com.order_service.dto;

public class OrderRequestDto {

    private String productName;

    private Integer quantity;

    private Double price;

    private Long userId;

	public OrderRequestDto(String productName, Integer quantity, Double price, Long userId) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.userId = userId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
    
}
