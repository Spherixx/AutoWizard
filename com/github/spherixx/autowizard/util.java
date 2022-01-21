package com.github.spherixx.autowizard;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import java.awt.*;
import java.awt.event.InputEvent;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

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
        Screen s = new Screen();
        // normalize the argument so its not case sensitive
        window.toLowerCase();
        s.setROI(695, 762, 530, 240);
        switch (window) {
            case "research":
                mouseInput("click", Config.mainButtonsX[0], Config.mainButtonsX[1]);
            break;
            case "enchant":
                mouseInput("click", Config.mainButtonsX[3], Config.mainButtonsX[1]);
            break;
            case "staff":
                mouseInput("click", Config.mainButtonsX[2], Config.mainButtonsX[1]);
            break;
            case "eye":
                mouseInput("click", Config.mainButtonsX[4], Config.mainButtonsX[1]);
            break;
            case "settings":
                mouseInput("click", Config.mainButtonsX[5], Config.mainButtonsX[0]);
            break;
            case "close":
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
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            break;
            case "rightclick":
            bot.mouseMove(x, y);
            bot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
            break;
            case "doubleclick":
            bot.mouseMove(x, y);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            bot.delay(50);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            break;
        }

    }
}
