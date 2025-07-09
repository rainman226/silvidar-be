package dev.Silvidar.dto;

import dev.Silvidar.enums.AnimalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ProductSearchDTO {
    private Long id;
    private String name;
    private AnimalType animalType;
    private float price;
    private String imageUrl;

    public ProductSearchDTO(Long id, String name, AnimalType animalType, float price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.animalType = animalType;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public float getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
