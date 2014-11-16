package com.igitras.axon.study.domain.event;

import com.igitras.axon.study.domain.DomainId;

/**
 * Created by mason on 11/15/14.
 */
public interface UpdatedEvent <I extends DomainId> {

    public I getIdentifier();
}