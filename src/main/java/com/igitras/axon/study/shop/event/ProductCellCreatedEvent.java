package com.igitras.axon.study.shop.event;

import com.igitras.axon.study.domain.event.CreatedEvent;
import com.igitras.axon.study.shop.ProductCellId;

/**
 * Created by mason on 11/16/14.
 */
public class ProductCellCreatedEvent implements CreatedEvent<ProductCellId> {

    private final ProductCellId identifier;
    private final int quantity;
    private final double price;

    public ProductCellCreatedEvent(ProductCellId identifier, int quantity, double price) {
        this.identifier = identifier;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public ProductCellId getIdentifier() {
        return identifier;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProductCellCreatedEvent{" +
                "identifier=" + identifier +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
