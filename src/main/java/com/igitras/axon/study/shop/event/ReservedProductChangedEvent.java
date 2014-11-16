package com.igitras.axon.study.shop.event;

import com.igitras.axon.study.domain.event.UpdatedEvent;
import com.igitras.axon.study.shop.ProductCellId;

/**
 * Created by mason on 11/16/14.
 */
public class ReservedProductChangedEvent implements UpdatedEvent<ProductCellId> {

    private final ProductCellId identifier;
    private final String orderId;
    private final int amount;

    public ReservedProductChangedEvent(ProductCellId identifier, String orderId, int amount) {
        this.identifier = identifier;
        this.orderId = orderId;
        this.amount = amount;
    }

    @Override
    public ProductCellId getIdentifier() {
        return identifier;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "ReservedProductChangedEvent{" +
                "identifier=" + identifier +
                ", orderId='" + orderId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
