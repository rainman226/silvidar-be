package dev.Silvidar.dto;

import dev.Silvidar.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UpdateOrderRequest {
    @NotNull(message = "Order status is required")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @FutureOrPresent(message = "Pick-up deadline must be in the present or future")
    private LocalDateTime pickUpDeadline;

    // IDs of OrderItems to remove (e.g., out-of-stock items)
    private List<Long> orderItemIdsToRemove = new ArrayList<>();

    public UpdateOrderRequest() {
    }

    public UpdateOrderRequest(OrderStatus orderStatus, LocalDateTime pickUpDeadline, List<Long> orderItemIdsToRemove) {
        this.orderStatus = orderStatus;
        this.pickUpDeadline = pickUpDeadline;
        this.orderItemIdsToRemove = orderItemIdsToRemove;
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

    public List<Long> getOrderItemIdsToRemove() {
        return orderItemIdsToRemove;
    }

    public void setOrderItemIdsToRemove(List<Long> orderItemIdsToRemove) {
        this.orderItemIdsToRemove = orderItemIdsToRemove;
    }
}
