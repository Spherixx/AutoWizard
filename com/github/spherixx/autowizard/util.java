package com.github.spherixx.autowizard;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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

    public static void getCurrentScreen() {
        // get a screenshot
        Screen s = new Screen();
        s.setROI(979, 197, 40, 40);
        try {
            s.find(Config.imagesPath + "research_screen_indicator.png");
            Config.currentScreen = "research";
        } catch (FindFailed e) {}
    }
}
