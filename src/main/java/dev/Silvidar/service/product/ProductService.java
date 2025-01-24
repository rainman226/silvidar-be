package dev.Silvidar.service.product;

import dev.Silvidar.enums.AnimalType;
import dev.Silvidar.model.Product;
import dev.Silvidar.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getProductByField(Long id,
                                           String name,
                                           AnimalType animalType,
                                           String foodType,
                                           Float price,
                                           Integer weight,
                                           boolean isAvailable,
                                           String code,
                                           Integer quantity) {
        Specification<Product> spec = Specification.where(null);
        if(id != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id));
        }

        if(name != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            System.out.println("am adaugat numele boss");
        }

        if(animalType != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("animalType"), animalType));
        }

        if(foodType != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("foodType")), "%" + foodType.toLowerCase() + "%"));
        }

        if (weight != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("weight"), weight));
        }

        if (isAvailable) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.isTrue(root.get("isAvailable")));
        }

        if (code != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("code")), "%" + code.toLowerCase() + "%"));
        }

        if (quantity != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("quantity"), quantity));
        }

        List<Product> products = productRepository.findAll(spec);

        if (products.isEmpty()) {
            System.out.println("No products found");
        }

        for(Product product : products) {
            System.out.println("Product: " + product);
        }
        return products;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
