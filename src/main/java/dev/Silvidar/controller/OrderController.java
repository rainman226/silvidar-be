package dev.Silvidar.controller;

import dev.Silvidar.dto.CreateOrderRequest;
import dev.Silvidar.dto.OrderDTO;
import dev.Silvidar.dto.UpdateOrderRequest;
import dev.Silvidar.model.Order;
import dev.Silvidar.service.order.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    private ModelMapper modelMapper = new ModelMapper();

    // TO BE DEPRECATED - use the search endpoint instead
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

    @GetMapping("/{id}")
    public ResponseEntity<List<OrderDTO>> getUserOrders(@PathVariable int id) {
        // TODO - validate with the JWT token that the user is allowed to access this endpoint
        List<Order> orders = orderService.getUserOrders(id);
        if (orders.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                orders.stream()
                        .map(order -> modelMapper.map(order, OrderDTO.class))
                        .toList()
        );
    }

    @PostMapping()
    public ResponseEntity<OrderDTO> createOrder(@RequestBody CreateOrderRequest request) {
        Order order = orderService.createOrder(request);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(order, OrderDTO.class));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long orderId, @RequestBody UpdateOrderRequest request) {
        Order updatedOrder = orderService.updateOrder(orderId, request);
        return ResponseEntity.ok(modelMapper.map(updatedOrder, OrderDTO.class));
    }
}
