package dev.Silvidar.service.order;

import dev.Silvidar.dto.CreateOrderRequest;
import dev.Silvidar.exceptions.ProductNotFoundException;
import dev.Silvidar.exceptions.UserNotFoundException;
import dev.Silvidar.model.Order;
import dev.Silvidar.model.OrderItem;
import dev.Silvidar.model.Product;
import dev.Silvidar.repository.OrderRepository;
import dev.Silvidar.repository.ProductRepository;
import dev.Silvidar.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getUserOrders(int userId) {
        return orderRepository.findByUser_Id(userId);
    }


    @Override
    @Transactional
    public Order createOrder(CreateOrderRequest request) {
        List<OrderItem> items = new ArrayList<>();
        float total = 0;

        // Validate request items
        if(request.getItems() != null && request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item.");
        }

        // First create the order so we add the persistance to the order items
        Order order = new Order();
        order.setUser(userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found: " + request.getUserId())));

        order.setOrderDate(java.time.LocalDateTime.now());
        order.setPickUpDeadline(request.getPickUpDeadline());
        order.setOrderStatus(dev.Silvidar.enums.OrderStatus.PENDING);

        // Fetch all product IDs from the request
        List<Long> productIds = request.getItems().stream()
                .map(CreateOrderRequest.OrderItemRequest::getProductId)
                .toList();

        // Batch fetch all products
        // We do this so we query the database only once for all products
        Map<Long, Product> productMap = productRepository.findAllById(productIds).stream()
                .collect(Collectors.toMap(Product::getId, p -> p));

        // Iterate through the items in the request and create OrderItem objects
        for(CreateOrderRequest.OrderItemRequest itemReq : request.getItems()) {

            Product product = productMap.get(itemReq.getProductId());

            if (product == null) {
                throw new ProductNotFoundException("Product not found: " + itemReq.getProductId());
            }

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
