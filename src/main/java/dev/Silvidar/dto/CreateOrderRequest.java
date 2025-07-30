package dev.Silvidar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public class CreateOrderRequest {

    @NotNull
    private int userId;

    @Future
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime pickUpDeadline;

    @NotEmpty
    private List<OrderItemRequest> items;

    public CreateOrderRequest(int userId, LocalDateTime pickUpDeadline, List<OrderItemRequest> items) {
        this.userId = userId;
        this.pickUpDeadline = pickUpDeadline;
        this.items = items;
    }

    public CreateOrderRequest() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getPickUpDeadline() {
        return pickUpDeadline;
    }

    public void setPickUpDeadline(LocalDateTime pickUpDeadline) {
        this.pickUpDeadline = pickUpDeadline;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }

    public static class OrderItemRequest {
        private Long productId;
        private int quantity;

        public OrderItemRequest(Long productId, int quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        public OrderItemRequest() {
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }


}