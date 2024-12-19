package labs.kpi.models;

import labs.kpi.annotations.MinValue;
import labs.kpi.annotations.NotNull;

/**
 * Represents an article with name, price, and stock quantity.
 *
 * @author Oleksii Kyrychenko
 */
public class Article {
    @NotNull
    private String name;

    @MinValue(0)
    private int price;

    @MinValue(0)
    private int stock;

    public Article(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}