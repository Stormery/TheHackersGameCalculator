package dev.stormery.event;

import dev.stormery.model.Programs;

/**
 * Created by Stormery on 2018-08-21.
 */
public class ActualizeProgramsEvent extends AbstractEvent<Object>{
    public ActualizeProgramsEvent(Object m){
        super(m);
    }
}
