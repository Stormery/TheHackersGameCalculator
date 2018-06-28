package dev.stormery.app;

import dev.stormery.controller.ListOfProgramsController;
import dev.stormery.ui.ListOfProgramsFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class that runs the application
 *
 *  Created by Stormery
 */
public class Main {
    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-config.xml");

        new ListOfProgramsController(context);

    }
}
