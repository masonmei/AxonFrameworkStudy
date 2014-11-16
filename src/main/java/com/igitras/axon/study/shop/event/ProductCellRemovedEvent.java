package com.igitras.axon.study.shop.event;

import com.igitras.axon.study.domain.event.DeletedEvent;
import com.igitras.axon.study.shop.ProductCellId;

/**
 * Created by mason on 11/16/14.
 */
public class ProductCellRemovedEvent implements DeletedEvent<ProductCellId> {

    private final ProductCellId identifier;

    public ProductCellRemovedEvent(ProductCellId identifier) {
        this.identifier = identifier;
    }

    @Override
    public ProductCellId getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return "ProductCellRemovedEvent{" +
                "identifier=" + identifier +
                '}';
    }
}
