package com.igitras.axon.study.shop;

import com.igitras.axon.study.domain.DomainLogic;

/**
 * Created by mason on 11/16/14.
 */
public interface ProductCellLogic extends DomainLogic {

    boolean isProductEnoughForNeed(int amountRequired);

    int removeAmountProductFromProductCell(int removedAmount);

    int addAmountProductToProductCell(int addedAmount);

    double changePrice(double newPrice);

    boolean isProductReservedForObject(String orderId);

    boolean isAmountReservedProductEnoughToRemove(String orderId, int amount);

    int removeAmountReservedProductForOrder(String orderId, int amountToRemove);

    int addReservedProductForOrder(String orderId, int amountToAdd);

    void reserveProductForOrder(String orderId, int amountToReserve);

    boolean isAnyReservedProductInProductCell();
}
