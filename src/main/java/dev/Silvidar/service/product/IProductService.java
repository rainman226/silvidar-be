package dev.Silvidar.service.product;

import dev.Silvidar.dto.ProductDTO;
import dev.Silvidar.enums.AnimalType;
import dev.Silvidar.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getAllProducts();
    public List<Product> getProductByField(Long id, String name, AnimalType animalType, String foodType, Float price, Integer weight, boolean isAvailable, String code, Integer quantity);
    //public ProductDTO convertToDto(Product product);
}
