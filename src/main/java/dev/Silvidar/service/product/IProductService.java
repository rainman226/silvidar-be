package dev.Silvidar.service.product;

import dev.Silvidar.dto.ProductDTO;
import dev.Silvidar.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getAllProducts();

    //public ProductDTO convertToDto(Product product);
}
