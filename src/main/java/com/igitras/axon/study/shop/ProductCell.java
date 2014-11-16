package com.igitras.axon.study.shop;

import com.igitras.axon.study.domain.Domain;
import com.igitras.axon.study.domain.command.CreateCommand;
import com.igitras.axon.study.domain.command.DeleteCommand;
import com.igitras.axon.study.domain.command.UpdateCommand;
import com.igitras.axon.study.domain.event.CreatedEvent;
import com.igitras.axon.study.domain.event.DeletedEvent;
import com.igitras.axon.study.domain.event.UpdatedEvent;
import com.igitras.axon.study.domain.exception.BaseException;
import com.igitras.axon.study.shop.command.*;
import com.igitras.axon.study.shop.event.*;
import com.igitras.axon.study.shop.exception.NoEnoughProductException;
import com.igitras.axon.study.shop.exception.NoEnoughProductForOrderException;
import com.igitras.axon.study.shop.exception.OrderNoFoundException;
import com.igitras.axon.study.shop.exception.ReservedProductsExistsException;
import com.jcabi.aspects.Loggable;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mason on 11/16/14.
 */
public class ProductCell extends ProductCellLogicImpl implements Domain<ProductCellId>, ProductCellHandler {

    public ProductCell() {
    }

    public ProductCell(CreateProductCellCommand command) {
        apply(new ProductCellCreatedEvent(command.getIdentifier(), command.getQuantity(), command.getPrice()));
    }

    @CommandHandler
    @Override
    public ProductCellCreatedEvent createProductCellCommand(CreateProductCellCommand command) {
        return null;
    }

    @EventSourcingHandler
    @Override
    public void productCellCreated(ProductCellCreatedEvent event) {
        this.identifier = event.getIdentifier();
        this.quantity = event.getQuantity();
        this.price = event.getPrice();
    }


    @Loggable(Loggable.DEBUG)
    @CommandHandler
    @Override
    public ProductQuantityChangedEvent addAmountProductToProductCellCommand(AddProductToProductCellCommand command) {
        ProductQuantityChangedEvent event = new ProductQuantityChangedEvent(command.getIdentifier(), addAmountProductToProductCell(command.getQuantity()));
        apply(event);
        return event;
    }

    @Loggable(Loggable.DEBUG)
    @CommandHandler
    @Override
    public ProductQuantityChangedEvent removeAmountProductFromProductCellCommand(RemoveProductFromProductCellCommand command) throws NoEnoughProductException {
        if (isProductEnoughForNeed(command.getQuantity())) {
            ProductQuantityChangedEvent event = new ProductQuantityChangedEvent(command.getIdentifier(), removeAmountProductFromProductCell(command.getQuantity()));
            apply(event);
            return event;
        }
        throw new NoEnoughProductException();
    }

    @EventSourcingHandler
    @Override
    public void productQuantityChangedInProductCellEvent(ProductQuantityChangedEvent event) {
        this.quantity = event.getQuantity();
    }

    @Loggable(Loggable.DEBUG)
    @CommandHandler
    @Override
    public ProductPriceChangedEvent changePriceInProductCellCommand(ChangePriceOfProductCommand command) {
        ProductPriceChangedEvent event = new ProductPriceChangedEvent(command.getIdentifier(), command.getPrice());
        apply(event);
        return event;
    }

    @EventSourcingHandler
    @Override
    public void productPriceChangedEvent(ProductPriceChangedEvent event) {
        this.price = event.getPrice();
    }

    @Loggable(Loggable.DEBUG)
    @CommandHandler
    @Override
    public List<Object> giveAmountProductFromProductCellForOrderCommand(GivenAmountProductFromProductCellToOrderCommand command) throws NoEnoughProductForOrderException {
        if (isProductEnoughForNeed(command.getQuantity())) {
            ProductQuantityChangedEvent event = new ProductQuantityChangedEvent(command.getIdentifier(), removeAmountProductFromProductCell(command.getQuantity()));

            ReservedProductChangedEvent event2 = new ReservedProductChangedEvent(command.getIdentifier(), command.getOrderId(), addReservedProductForOrder(command.getOrderId(), command.getQuantity()));
            apply(event);
            apply(event2);
            return Arrays.asList(event, event2);
        }
        return null;
    }

    @Loggable(Loggable.DEBUG)
    @CommandHandler
    @Override
    public List<Object> returnAmountProductFromOrderToProductCellCommand(ReturnAmountProductFromProductCellToOrderCommand command) throws OrderNoFoundException {

        if (isProductReservedForObject(command.getOrderId())) {
            ProductQuantityChangedEvent event = new ProductQuantityChangedEvent(command.getIdentifier(), addAmountProductToProductCell(command.getQuantity()));

            ReservedProductChangedEvent event2 = new ReservedProductChangedEvent(command.getIdentifier(), command.getOrderId(), removeAmountReservedProductForOrder(command.getOrderId(), command.getQuantity()));
            apply(event);
            apply(event2);
            return Arrays.asList(event, event2);
        }
        throw new OrderNoFoundException();

    }

    @EventSourcingHandler
    @Override
    public void reservedProductChangedInProductCellEvent(ReservedProductChangedEvent event) {
        reserveProductForOrder(event.getOrderId(), event.getAmount());
    }

    @Loggable(Loggable.DEBUG)
    @CommandHandler
    @Override
    public ProductCellRemovedEvent removeProductCell(RemoveProductCellCommand command) throws ReservedProductsExistsException {
        if(isAnyReservedProductInProductCell()){
            throw new ReservedProductsExistsException();
        }

        ProductCellRemovedEvent event = new ProductCellRemovedEvent(command.getIdentifier());
        apply(event);
        return event;
    }

    @Override
    public void productCellRemovedEvent(ProductCellRemovedEvent event) {
        markDeleted();
    }

    @Override
    public <C extends CreateCommand, E extends CreatedEvent> E handle(C createCommand) throws BaseException {
        return null;
    }

    @Override
    public <C extends UpdateCommand, E extends UpdatedEvent> E handle(C updateCommand) throws BaseException {
        return null;
    }

    @Override
    public <C extends DeleteCommand, E extends DeletedEvent> E handle(C deleteCommand) throws BaseException {
        return null;
    }
}
