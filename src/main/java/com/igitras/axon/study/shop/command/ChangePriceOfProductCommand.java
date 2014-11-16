package com.igitras.axon.study.shop.command;

import com.igitras.axon.study.domain.command.UpdateCommand;
import com.igitras.axon.study.shop.ProductCellId;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.hibernate.annotations.Target;

/**
 * Created by mason on 11/16/14.
 */
public class ChangePriceOfProductCommand implements UpdateCommand<ProductCellId> {

    @TargetAggregateIdentifier
    private final ProductCellId identifier;
    private final double price;

    public ChangePriceOfProductCommand(ProductCellId identifier, double price) {
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
        return "ChangePriceOfProductCommand{" +
                "identifier=" + identifier +
                '}';
    }
}
