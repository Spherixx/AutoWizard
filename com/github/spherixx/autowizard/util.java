package com.github.spherixx.autowizard;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import java.awt.*;
import java.awt.event.InputEvent;

import org.sikuli.script.FindFailed;

public class util {

    public static void log(Level logLevel, String logData) {
        Logger logger = Logger.getLogger("AutoWizard.log");  
        FileHandler fh;  

        try {
            // This block configure the logger with handler and formatter  
            fh = new FileHandler("C:/Users/Spherix/AutoWizard/AutoWizard.log");  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  
            
            // the following statement is used to log any messages  
            logger.log(logLevel, logData);

        } catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        
        // close the filehandler
        //fh.close();

    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public static void currentWindow(String window) throws FindFailed, AWTException {
        // normalize the argument so its not case sensitive
        window.toLowerCase();
        mouseInput("click", 950, 740);
        sleep(500);
        switch (window) {
            case "research":
            if (Config.debug) System.out.println("Opening research");
            mouseInput("click", Config.mainButtonsX[0], Config.mainButtonsY[1]);
            break;
            case "enchant":
            if (Config.debug) System.out.println("Opening enchant");
            mouseInput("click", Config.mainButtonsX[3], Config.mainButtonsY[1]);
            break;
            case "staff":
            if (Config.debug) System.out.println("Opening staff");
            mouseInput("click", Config.mainButtonsX[2], Config.mainButtonsY[1]);
            break;
            case "eye":
            if (Config.debug) System.out.println("Opening eye");
            mouseInput("click", Config.mainButtonsX[4], Config.mainButtonsY[1]);
            break;
            case "settings":
            if (Config.debug) System.out.println("Opening settings");
            mouseInput("click", Config.mainButtonsX[5], Config.mainButtonsY[0]);
            break;
            case "close":
            if (Config.debug) System.out.println("Closing window");
            mouseInput("click", 950, 740);
            break;
        }
    }

    public static void mouseInput(String command, int x, int y) throws AWTException {
        command.toLowerCase();
        Robot bot = new Robot();
        switch (command) {
            case "move":
            bot.mouseMove(x, y);
            break;
            case "click":
            bot.mouseMove(x, y);
            bot.delay(100);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            break;
            case "rightclick":
            bot.mouseMove(x, y);
            bot.delay(100);
            bot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
            break;
            case "doubleclick":
            bot.mouseMove(x, y);
            bot.delay(100);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            bot.delay(50);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            break;
        }

    }
}
