package dev.stormery.event;

/**
 * Part of the Observer design pattern, <br>
 *
 */
public class AbstractEvent<Target> {

    private Target target;

    public AbstractEvent(Target target){
        this.target = target;
    }

    /*Informacje które są zapisane w target wracają przy wywołaniu tej metody w
    ListOfProgramsController
    */
    public Target getTarget(){
        return target;
    }

}
