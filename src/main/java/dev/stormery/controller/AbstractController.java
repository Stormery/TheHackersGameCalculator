package dev.stormery.controller;

import dev.stormery.event.AbstractEventListener;
import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stormery on 2018-07-18.
 */
public abstract class AbstractController implements ActionListener, WindowListener{

    protected static Logger log = Logger.getLogger(AbstractController.class);

    private Map<Class<?>, List<AbstractEventListener<?>>> eventListeners =
            new HashMap<Class<?>, List<AbstractEventListener<?>>>();

    protected void registerEventListener(Class<?> eventClass, AbstractEventListener<?> eventListener){
      log.debug("Rejestracje Listenera: " + eventListener + "dla wydarzenia: " + eventClass.getName());
        List<AbstractEventListener<?>> listOfListenersForEvent = eventListeners.get(eventClass);
        if(listOfListenersForEvent == null){
            listOfListenersForEvent = new ArrayList<AbstractEventListener<?>>();
        }
        listOfListenersForEvent.add(eventListener);
        eventListeners.put(eventClass,listOfListenersForEvent);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Method used to release resources loaded by the controller.
     */
    protected void cleanUp(){}

    @Override
    public void windowClosing(WindowEvent e) {
        cleanUp();
    }

    public void windowOpened(WindowEvent windowEvent) {}
    public void windowClosed(WindowEvent windowEvent) {}
    public void windowIconified(WindowEvent windowEvent) {}
    public void windowDeiconified(WindowEvent windowEvent) {}
    public void windowActivated(WindowEvent windowEvent) {}
    public void windowDeactivated(WindowEvent windowEvent) {}
}
