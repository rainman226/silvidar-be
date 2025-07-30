package dev.Silvidar.dto;

import dev.Silvidar.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private Long oid;
    private Long userId;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private LocalDateTime pickUpDeadline;
    private float totalPrice;
    private List<OrderItemDTO> orderItems;

    public OrderDTO(Long oid, Long userId, LocalDateTime orderDate, OrderStatus orderStatus, LocalDateTime pickUpDeadline, float totalPrice, List<OrderItemDTO> orderItems) {
        this.oid = oid;
        this.userId = userId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.pickUpDeadline = pickUpDeadline;
        this.totalPrice = totalPrice;
        this.orderItems = orderItems;
    }

    public OrderDTO() {
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getPickUpDeadline() {
        return pickUpDeadline;
    }

    public void setPickUpDeadline(LocalDateTime pickUpDeadline) {
        this.pickUpDeadline = pickUpDeadline;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
