package com.igitras.axon.study.shop;

import com.igitras.axon.study.domain.DomainHandler;
import com.igitras.axon.study.shop.command.*;
import com.igitras.axon.study.shop.event.*;
import com.igitras.axon.study.shop.exception.NoEnoughProductException;
import com.igitras.axon.study.shop.exception.NoEnoughProductForOrderException;
import com.igitras.axon.study.shop.exception.OrderNoFoundException;
import com.igitras.axon.study.shop.exception.ReservedProductsExistsException;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

import java.util.List;

/**
 * Created by mason on 11/16/14.
 */
public interface ProductCellHandler extends DomainHandler {

    @CommandHandler
    public ProductCellCreatedEvent createProductCellCommand(CreateProductCellCommand command);

    @EventSourcingHandler
    void productCellCreated(ProductCellCreatedEvent event);

    @CommandHandler
    public ProductQuantityChangedEvent addAmountProductToProductCellCommand(AddProductToProductCellCommand command);

    @CommandHandler
    public ProductQuantityChangedEvent removeAmountProductFromProductCellCommand(RemoveProductFromProductCellCommand command) throws NoEnoughProductException;

    @EventSourcingHandler
    public void productQuantityChangedInProductCellEvent(ProductQuantityChangedEvent event);

    @CommandHandler
    public ProductPriceChangedEvent changePriceInProductCellCommand(ChangePriceOfProductCommand command);

    @EventSourcingHandler
    public void productPriceChangedEvent(ProductPriceChangedEvent event);

    @CommandHandler
    public List<Object> giveAmountProductFromProductCellForOrderCommand(GivenAmountProductFromProductCellToOrderCommand command) throws NoEnoughProductForOrderException;

    @CommandHandler
    public List<Object> returnAmountProductFromOrderToProductCellCommand(ReturnAmountProductFromProductCellToOrderCommand command) throws OrderNoFoundException;

    @EventSourcingHandler
    public void reservedProductChangedInProductCellEvent(ReservedProductChangedEvent event);

    @CommandHandler
    public ProductCellRemovedEvent removeProductCell(RemoveProductCellCommand command) throws ReservedProductsExistsException;

    @EventSourcingHandler
    public void productCellRemovedEvent(ProductCellRemovedEvent event);
}
