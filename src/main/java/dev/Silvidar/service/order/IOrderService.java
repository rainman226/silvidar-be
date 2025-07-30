package dev.Silvidar.service.order;

import dev.Silvidar.dto.CreateOrderRequest;
import dev.Silvidar.dto.UpdateOrderRequest;
import dev.Silvidar.model.Order;

import java.util.List;

public interface IOrderService {
    public List<Order> getAllOrders();
    public Order createOrder(CreateOrderRequest request);
    public List<Order> getUserOrders(int userId);
    public Order updateOrder(Long orderId, UpdateOrderRequest request);
}
