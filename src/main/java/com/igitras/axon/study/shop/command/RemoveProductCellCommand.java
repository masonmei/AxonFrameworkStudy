package com.igitras.axon.study.shop.command;

import com.igitras.axon.study.domain.command.DeleteCommand;
import com.igitras.axon.study.shop.ProductCellId;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by mason on 11/16/14.
 */
public class RemoveProductCellCommand implements DeleteCommand<ProductCellId> {

    @TargetAggregateIdentifier
    private final ProductCellId identifier;

    public RemoveProductCellCommand(ProductCellId identifier) {
        this.identifier = identifier;
    }

    @Override
    public ProductCellId getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return "RemoveProductCellCommand{" +
                "identifier=" + identifier +
                '}';
    }
}
