package dev.stormery.event;

import dev.stormery.model.Programs;

/**
 *      Generates event while Program is added<br>
 *    included <code>Programs</code> reference is received
 */
public class AddProgramsEvent extends AbstractEvent<Programs>{
    public AddProgramsEvent(Programs p){
        super(p);
    }
}
