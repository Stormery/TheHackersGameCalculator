package dev.stormery.event;

import dev.stormery.action.AbstractAction;
import dev.stormery.model.Programs;

/**
 * Created by Stormery on 2018-08-21. TODO description
 */
public class DeleteProgramEvent extends AbstractEvent<Programs>{
    public DeleteProgramEvent(Programs p){
        super(p);

    }
}
