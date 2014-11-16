package com.igitras.axon.study.shop.event;

import com.igitras.axon.study.domain.event.UpdatedEvent;
import com.igitras.axon.study.shop.ProductCellId;

/**
 * Created by mason on 11/16/14.
 */
public class ProductQuantityChangedEvent implements UpdatedEvent<ProductCellId> {

    private final ProductCellId identifier;
    private final int quantity;

    public ProductQuantityChangedEvent(ProductCellId identifier, int quantity) {
        this.identifier = identifier;
        this.quantity = quantity;
    }

    @Override
    public ProductCellId getIdentifier() {
        return identifier;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ProductQuantityChangedEvent{" +
                "identifier=" + identifier +
                ", quantity=" + quantity +
                '}';
    }
}
