package com.igitras.axon.study.shop;

import com.jcabi.aspects.Loggable;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mason on 11/16/14.
 */
public class ProductCellLogicImpl extends AbstractAnnotatedAggregateRoot<ProductCellId> implements ProductCellLogic {

    @AggregateIdentifier
    protected ProductCellId identifier;
    protected int quantity;
    protected double price;

    protected Map<String, Integer> reservedProduct = new HashMap<String, Integer>();

    public ProductCellLogicImpl() {
    }

    @Loggable(Loggable.DEBUG)
    @Override
    public boolean isProductEnoughForNeed(int amountRequired) {
        return quantity >= amountRequired;
    }

    @Loggable(Loggable.DEBUG)
    @Override
    public int removeAmountProductFromProductCell(int removedAmount) {
        return quantity - removedAmount;
    }

    @Loggable(Loggable.DEBUG)
    @Override
    public int addAmountProductToProductCell(int addedAmount) {
        return quantity + addedAmount;
    }

    @Loggable(Loggable.DEBUG)
    @Override
    public double changePrice(double newPrice) {
        return newPrice;
    }

    @Loggable(Loggable.DEBUG)
    @Override
    public boolean isProductReservedForObject(String orderId) {
        return reservedProduct.containsKey(orderId);
    }

    @Loggable(Loggable.DEBUG)
    @Override
    public boolean isAmountReservedProductEnoughToRemove(String orderId, int amount) {
        return reservedProduct.get(orderId) >= amount;
    }

    @Loggable(Loggable.DEBUG)
    @Override
    public int removeAmountReservedProductForOrder(String orderId, int amountToRemove) {
        return reservedProduct.get(orderId) - amountToRemove;
    }

    @Loggable(Loggable.DEBUG)
    @Override
    public int addReservedProductForOrder(String orderId, int amountToAdd) {
        int newAmount = 0;
        if (isProductReservedForObject(orderId)) {
            newAmount = reservedProduct.get(orderId) + amountToAdd;
        } else {
            newAmount = amountToAdd;
        }
        return newAmount;
    }

    @Loggable(Loggable.DEBUG)
    @Override
    public void reserveProductForOrder(String orderId, int amountToReserve) {
        if (amountToReserve == 0) {
            reservedProduct.remove(orderId);
        } else {
            reservedProduct.put(orderId, amountToReserve);
        }
    }

    @Loggable(Loggable.DEBUG)
    @Override
    public boolean isAnyReservedProductInProductCell() {
        return !reservedProduct.isEmpty();
    }
}
