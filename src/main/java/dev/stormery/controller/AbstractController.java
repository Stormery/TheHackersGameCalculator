package dev.stormery.controller;

import dev.stormery.action.*;
import dev.stormery.action.AbstractAction;
import dev.stormery.event.AbstractEventListener;
import org.apache.log4j.Logger;

import javax.swing.*;
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

    private AbstractController parent;

    private Map<String,AbstractAction> actionsMap = new HashMap<String, AbstractAction>();

    private Map<Class<?>, List<AbstractEventListener<?>>> eventListeners =
            new HashMap<Class<?>, List<AbstractEventListener<?>>>();

    public AbstractController(){this(null);}

    /**
     * ?
     * @param parent
     */
    public AbstractController(AbstractController parent){
        this.parent= parent;
    }
//----------------------------------------------------------------------------------------------------------------------
   protected void registerAction(AbstractButton sourceButton, AbstractAction action){
       if(sourceButton.getActionCommand() == null){
           throw new RuntimeException("Button has no action!");
       }
       log.debug("Register action :" + action.getClass().getName() + " for button: " + sourceButton.getText());

       //Adding action to listener
       sourceButton.addActionListener(this);

       //Map action with ActionCommand
       this.actionsMap.put(sourceButton.getActionCommand(),action);

   }
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Rejestruje działanie na komponencie
     * @param eventClass
     * @param eventListener
     */
    protected void registerEventListener(Class<?> eventClass, AbstractEventListener<?> eventListener){
      log.debug("@Registers Listener: " + eventListener + "for Event: " + eventClass.getName());
        List<AbstractEventListener<?>> listOfListenersForEvent = eventListeners.get(eventClass);
        if(listOfListenersForEvent == null){
            listOfListenersForEvent = new ArrayList<AbstractEventListener<?>>();
        }
        listOfListenersForEvent.add(eventListener);
        eventListeners.put(eventClass,listOfListenersForEvent);
    }
//--------------------------------------------Listener actionPerformed--------------------------------------------------

    /**
     * After getting Action from <code>actionsMap</code> it causes situations related to object which is assigned in its action() method.
     * @param actionEvent Action performed from a button action
     */
    public void actionPerformed(ActionEvent actionEvent) {
        //TODO wywolanie akcji listenera
        System.err.println("click");

        try {
            AbstractButton button = (AbstractButton)actionEvent.getSource();
            String actionCommand = button.getActionCommand();
            AbstractAction action = actionsMap.get(actionCommand);

            if(action !=null){
                log.debug("Loading command: "+ actionCommand + " from: "  +action.getClass());
                try{
                    action.actionPerformed();
                }catch(Exception ex){
                    exceptionHandler(ex);
                }
            }



        }catch (ClassCastException e){
            exceptionHandler(new IllegalArgumentException("Action source is not abstract button: " + actionEvent));
        }

    }
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Use for popup error if occured
     */
    public void exceptionHandler(Exception ex){
        log.error(ex);
        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
    }
//----------------------------------------------------------------------------------------------------------------------
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
