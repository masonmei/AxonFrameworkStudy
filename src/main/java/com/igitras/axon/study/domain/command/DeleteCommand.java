package com.igitras.axon.study.domain.command;

import com.igitras.axon.study.domain.DomainId;

/**
 * Created by mason on 11/15/14.
 */
public interface DeleteCommand <I extends DomainId> {

    public I getIdentifier();
}
