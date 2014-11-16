package com.igitras.axon.study.domain;

import java.io.Serializable;

/**
 * Created by mason on 11/15/14.
 */
public interface Domain<I extends DomainId> extends Serializable, DomainHandler {

    public I getIdentifier();

}
