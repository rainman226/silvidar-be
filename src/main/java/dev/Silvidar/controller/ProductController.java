package dev.Silvidar.controller;


import dev.Silvidar.dto.ProductSearchDTO;
import dev.Silvidar.enums.AnimalType;
import dev.Silvidar.model.Product;
import dev.Silvidar.service.product.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/search")
    public ResponseEntity<List<ProductSearchDTO>> searchProduct(@RequestParam(required = false) Long id,
                                                           @RequestParam(required = false) String name,
                                                           @RequestParam(required = false) AnimalType animalType,
                                                           @RequestParam(required = false) String foodType,
                                                           @RequestParam(required = false) Float price,
                                                           @RequestParam(required = false) Integer weight,
                                                           @RequestParam(required = false) boolean isAvailable,
                                                           @RequestParam(required = false) String code,
                                                           @RequestParam(required = false) Integer quantity) {
            List<Product> searchResult = productService.searchForProduct(id, name, animalType, foodType, price, weight, isAvailable, code, quantity);
            if (!searchResult.isEmpty()) {
                List<ProductSearchDTO> productDTOs = new ArrayList<>();

                // TODO - actually use a Mapper here lmao
                for (Product product : searchResult) {
                    ProductSearchDTO productDTO = modelMapper.map(product, ProductSearchDTO.class);

                    System.out.println("Product DTO: " + productDTO);
                    productDTOs.add(productDTO);
                }

                return ResponseEntity.ok(productDTOs);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        Product product = productService.getProductById(id);

        return ResponseEntity.ok(product);
    }

    // TO BE DEPRECATED - use the search endpoint instead
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

}
