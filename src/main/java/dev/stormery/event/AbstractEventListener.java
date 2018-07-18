package dev.stormery.event;

/**
 * Part of the Observer design pattern, <br>
 * other are: <code>AbstractController</code> and <code> AbstractEvent</code>
 * <br><br>
 * This <code>AbstractEventListener</code> is working as Observer/Subject
 */
public interface AbstractEventListener<M extends AbstractEvent<?>> {

    public void handleEvent(M event);

}

