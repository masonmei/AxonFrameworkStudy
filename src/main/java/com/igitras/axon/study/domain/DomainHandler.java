package com.igitras.axon.study.domain;

import com.igitras.axon.study.domain.command.CreateCommand;
import com.igitras.axon.study.domain.command.DeleteCommand;
import com.igitras.axon.study.domain.command.UpdateCommand;
import com.igitras.axon.study.domain.event.CreatedEvent;
import com.igitras.axon.study.domain.event.DeletedEvent;
import com.igitras.axon.study.domain.event.UpdatedEvent;
import com.igitras.axon.study.domain.exception.BaseException;

/**
 * Created by mason on 11/15/14.
 */
public interface DomainHandler {

    public <C extends CreateCommand, E extends CreatedEvent> E handle(C createCommand) throws BaseException;

    public <C extends UpdateCommand, E extends UpdatedEvent> E handle(C updateCommand) throws BaseException;

    public <C extends DeleteCommand, E extends DeletedEvent> E handle(C deleteCommand) throws BaseException;
}
