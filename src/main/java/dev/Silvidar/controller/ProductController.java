package dev.Silvidar.controller;

import dev.Silvidar.dto.ProductDTO;
import dev.Silvidar.enums.AnimalType;
import dev.Silvidar.model.Product;
import dev.Silvidar.service.product.IProductService;
import dev.Silvidar.service.product.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Product>> getProductByField(@RequestParam(required = false) Long id,
                                                           @RequestParam(required = false) String name,
                                                           @RequestParam(required = false) AnimalType animalType,
                                                           @RequestParam(required = false) String foodType,
                                                           @RequestParam(required = false) Float price,
                                                           @RequestParam(required = false) Integer weight,
                                                           @RequestParam(required = false) boolean isAvailable,
                                                           @RequestParam(required = false) String code,
                                                           @RequestParam(required = false) Integer quantity) {
            List<Product> searchResult = productService.getProductByField(id, name, animalType, foodType, price, weight, isAvailable, code, quantity);
            if (searchResult.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.ok(searchResult);
            }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
