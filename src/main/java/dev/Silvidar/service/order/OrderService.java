package dev.Silvidar.service.order;

import dev.Silvidar.dto.CreateOrderRequest;
import dev.Silvidar.model.Order;
import dev.Silvidar.model.OrderItem;
import dev.Silvidar.model.Product;
import dev.Silvidar.repository.OrderRepository;
import dev.Silvidar.repository.ProductRepository;
import dev.Silvidar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    // TODO - actually use DTOs so we don't expose our entities directly
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getUserOrders(int userId) {
        return orderRepository.findByUser_Id(userId);
    }


    @Override
    public Order createOrder(CreateOrderRequest request) {
        List<OrderItem> items = new ArrayList<>();
        float total = 0;

        // First create the order so we add the persistance to the order items
        Order order = new Order();
        order.setUser(userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found: " + request.getUserId())));

        order.setOrderDate(java.time.LocalDateTime.now());
        order.setPickUpDeadline(request.getPickUpDeadline());
        order.setOrderStatus(dev.Silvidar.enums.OrderStatus.PENDING);

        // Iterate through the items in the request and create OrderItem objects
        for(CreateOrderRequest.OrderItemRequest itemReq : request.getItems()) {
            Product product = productRepository.findById(itemReq.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found: " + itemReq.getProductId()));

            OrderItem item = new OrderItem();

            item.setProduct(product);
            item.setQuantity(itemReq.getQuantity());
            item.setUnitPrice(product.getPrice());
            item.setOrder(order); // Set the order for the item

            total += item.getUnitPrice() * item.getQuantity();

            items.add(item);
        }

        order.setOrderItems(items);
        order.setTotalPrice(total);

        return orderRepository.save(order);
    }
}
