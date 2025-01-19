package dev.Silvidar.dto;

import dev.Silvidar.enums.AnimalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private AnimalType animalType;
    private String foodType;
    private float price;
    private int weight;
    private boolean isAvailable;
    private String code;
    private int quantity;
    private String description;
    private String imageUrl;
}
