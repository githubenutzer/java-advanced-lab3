package labs.kpi.models;

import labs.kpi.annotations.MinValue;
import labs.kpi.annotations.NotNull;

/**
 * Represents an order with an ID, quantity, and total amount.
 *
 * @author Oleksii Kyrychenko
 */
public class Order {
    @NotNull
    private String orderId;

    @MinValue(1)
    private int quantity;

    @MinValue(0)
    private int totalAmount;

    public Order(String orderId, int quantity, int totalAmount) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }
}