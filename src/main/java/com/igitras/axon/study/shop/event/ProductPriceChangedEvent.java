package com.igitras.axon.study.shop.event;

import com.igitras.axon.study.domain.event.UpdatedEvent;
import com.igitras.axon.study.shop.ProductCellId;

/**
 * Created by mason on 11/16/14.
 */
public class ProductPriceChangedEvent implements UpdatedEvent<ProductCellId> {

    private final ProductCellId identifier;
    private final double price;

    public ProductPriceChangedEvent(ProductCellId identifier, double price) {
        this.identifier = identifier;
        this.price = price;
    }

    @Override
    public ProductCellId getIdentifier() {
        return identifier;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProductPriceChangedEvent{" +
                "identifier=" + identifier +
                ", price=" + price +
                '}';
    }
}
