package com.igitras.axon.study.shop.command;

import com.igitras.axon.study.domain.command.UpdateCommand;
import com.igitras.axon.study.shop.ProductCellId;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by mason on 11/16/14.
 */
public class GivenAmountProductFromProductCellToOrderCommand implements UpdateCommand<ProductCellId> {

    @TargetAggregateIdentifier
    private final ProductCellId identifier;
    private final String orderId;
    private final int quantity;

    public GivenAmountProductFromProductCellToOrderCommand(ProductCellId identifier, String orderId, int quantity) {
        this.identifier = identifier;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    @Override
    public ProductCellId getIdentifier() {
        return identifier;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "GivenAmountProductFromProductCellToOrderCommand{" +
                "identifier=" + identifier +
                ", orderId='" + orderId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
