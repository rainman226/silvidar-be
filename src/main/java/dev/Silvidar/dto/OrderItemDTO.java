package dev.Silvidar.dto;

public class OrderItemDTO {
    private int quantity;
    private float unitPrice;
    private ProductSummaryDTO product;

    public OrderItemDTO(int quantity, float priceAtOrderTime, ProductSummaryDTO product) {
        this.quantity = quantity;
        this.unitPrice = priceAtOrderTime;
        this.product = product;
    }

    public OrderItemDTO() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public ProductSummaryDTO getProduct() {
        return product;
    }

    public void setProduct(ProductSummaryDTO product) {
        this.product = product;
    }
}
