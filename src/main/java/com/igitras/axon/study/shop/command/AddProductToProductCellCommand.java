package com.igitras.axon.study.shop.command;

import com.igitras.axon.study.domain.command.UpdateCommand;
import com.igitras.axon.study.shop.ProductCellId;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by mason on 11/16/14.
 */
public class AddProductToProductCellCommand implements UpdateCommand<ProductCellId> {

    @TargetAggregateIdentifier
    private final ProductCellId identifier;
    private final int quantity;

    public AddProductToProductCellCommand(ProductCellId identifier, int quantity) {
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
        return "AddProductToProductCellCommand{" +
                "identifier=" + identifier +
                ", quantity=" + quantity +
                '}';
    }
}
