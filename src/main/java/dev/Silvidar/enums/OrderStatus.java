package dev.Silvidar.enums;

public enum OrderStatus {
    PENDING,        // Order has been placed but not yet processed
    CONFIRMED,      // Order has been confirmed by the store
    PREPARING,      // Order is being prepared
    READY_FOR_PICKUP, // Order is ready for pickup
    COMPLETED,      // Order has been completed and picked up or delivered
    CANCELLED       // Order has been cancelled
}
