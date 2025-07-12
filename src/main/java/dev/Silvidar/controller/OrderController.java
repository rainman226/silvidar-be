package dev.Silvidar.controller;

import dev.Silvidar.dto.CreateOrderRequest;
import dev.Silvidar.dto.OrderDTO;
import dev.Silvidar.model.Order;
import dev.Silvidar.repository.OrderRepository;
import dev.Silvidar.service.order.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping()
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(
                orders.stream()
                        .map(order -> modelMapper.map(order, OrderDTO.class))
                        .toList()
        );
    }

    @PostMapping()
    public ResponseEntity<OrderDTO> createOrder(@RequestBody CreateOrderRequest request) {
        Order order = orderService.createOrder(request);
        if (order == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(modelMapper.map(order, OrderDTO.class));
    }
}
