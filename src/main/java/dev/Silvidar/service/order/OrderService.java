package dev.Silvidar.service.order;

import dev.Silvidar.model.Order;
import dev.Silvidar.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;

    // TODO - actually use DTOs so we don't expose our entities directly
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
