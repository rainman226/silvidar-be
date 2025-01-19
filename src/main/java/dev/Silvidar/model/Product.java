package dev.Silvidar.model;

import dev.Silvidar.enums.AnimalType;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    private String foodType;

    private float price;

    private int weight;

    private boolean isAvailable;

    private String code;

    private int quantity;

    private String description;

    private String imageUrl;

    public Product(Long id, String name, AnimalType animalType, String foodType, float price, int weight, boolean isAvailable, String code, int quantity, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.animalType = animalType;
        this.foodType = foodType;
        this.price = price;
        this.weight = weight;
        this.isAvailable = isAvailable;
        this.code = code;
        this.quantity = quantity;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(price, product.price) == 0 && weight == product.weight && isAvailable == product.isAvailable && quantity == product.quantity && Objects.equals(id, product.id) && Objects.equals(name, product.name) && animalType == product.animalType && Objects.equals(foodType, product.foodType) && Objects.equals(code, product.code) && Objects.equals(description, product.description) && Objects.equals(imageUrl, product.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, animalType, foodType, price, weight, isAvailable, code, quantity, description, imageUrl);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", animalType=" + animalType +
                ", foodType='" + foodType + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", isAvailable=" + isAvailable +
                ", code='" + code + '\'' +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
