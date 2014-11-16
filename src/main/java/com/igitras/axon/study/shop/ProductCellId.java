package com.igitras.axon.study.shop;

import com.igitras.axon.study.domain.DomainId;
import org.axonframework.domain.IdentifierFactory;

/**
 * Created by mason on 11/16/14.
 */
public class ProductCellId implements DomainId {

    private final String identifier;

    public ProductCellId() {
        this.identifier = IdentifierFactory.getInstance().generateIdentifier();
    }

    public ProductCellId(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductCellId)) return false;

        ProductCellId that = (ProductCellId) o;

        if (identifier != null ? !identifier.equals(that.identifier) : that.identifier != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return identifier != null ? identifier.hashCode() : 0;
    }

    @Override
    public String toString() {
        return identifier;
    }
}
