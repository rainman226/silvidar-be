package dev.Silvidar.model;

import dev.Silvidar.enums.AnimalType;
import dev.Silvidar.enums.LifeStage;
import jakarta.persistence.*;

import java.util.Date;
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

    @Enumerated(EnumType.STRING)
    private LifeStage lifeStage;

    private String foodType;

    private String flavour;

    private float price;

    private float weight;

    private boolean isAvailable;

    private String code;

    private int quantity;

    private String description;

    private String nutritionalInformation;

    private String imageUrl;

    private Date createdAt;

    private Date updatedAt;

    public Product() {
    }

    public Product(Long id, String name, AnimalType animalType, LifeStage lifeStage, String foodType, String flavour, float price, float weight, boolean isAvailable, String code, int quantity, String description, String nutritionalInformation, String imageUrl, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.animalType = animalType;
        this.lifeStage = lifeStage;
        this.foodType = foodType;
        this.flavour = flavour;
        this.price = price;
        this.weight = weight;
        this.isAvailable = isAvailable;
        this.code = code;
        this.quantity = quantity;
        this.description = description;
        this.nutritionalInformation = nutritionalInformation;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public LifeStage getLifeStage() {
        return lifeStage;
    }

    public void setLifeStage(LifeStage lifeStage) {
        this.lifeStage = lifeStage;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
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

    public String getNutritionalInformation() {
        return nutritionalInformation;
    }

    public void setNutritionalInformation(String nutritionalInformation) {
        this.nutritionalInformation = nutritionalInformation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(price, product.price) == 0 && Float.compare(weight, product.weight) == 0 && isAvailable == product.isAvailable && quantity == product.quantity && Objects.equals(id, product.id) && Objects.equals(name, product.name) && animalType == product.animalType && lifeStage == product.lifeStage && Objects.equals(foodType, product.foodType) && Objects.equals(flavour, product.flavour) && Objects.equals(code, product.code) && Objects.equals(description, product.description) && Objects.equals(nutritionalInformation, product.nutritionalInformation) && Objects.equals(imageUrl, product.imageUrl) && Objects.equals(createdAt, product.createdAt) && Objects.equals(updatedAt, product.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, animalType, lifeStage, foodType, flavour, price, weight, isAvailable, code, quantity, description, nutritionalInformation, imageUrl, createdAt, updatedAt);
    }
}
