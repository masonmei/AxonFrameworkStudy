package com.igitras.axon.study.shop.command;

import com.igitras.axon.study.domain.command.CreateCommand;
import com.igitras.axon.study.shop.ProductCellId;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by mason on 11/16/14.
 */
public class CreateProductCellCommand implements CreateCommand<ProductCellId> {

    @TargetAggregateIdentifier
    private final ProductCellId identifier;
    private final int quantity;
    private final double price;

    public CreateProductCellCommand(ProductCellId identifier, int quantity, double price) {
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
        return "CreateProductCellCommand{" +
                "identifier=" + identifier +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
