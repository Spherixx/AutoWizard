import org.sikuli.script.FindFailed;
import org.sikuli.script.Region;
import org.sikuli.script.SX;
import org.sikuli.script.Screen;
import org.sikuli.script.Sikulix;
import org.sikuli.script.support.SikulixAPI;

import java.io.IOException;
import java.lang.module.FindException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class testing {
    // toggles console debugging on or off
    static boolean debug = true;
    /*
        logLevel
            0: logging off
            1: error logging and minor info logging
            2: error logging and all info logging
    */
    static int logLevel = 0;
    // main loop runs while this is true
    static boolean running = true;

    // bot stuff
    static String imagesPath = "C:/Users/Spherix/AutoWizard/images/";

    // main buttons
    static String[] mainButtons = {"button_research", "button_staff", "button_eye", "button_enchant"};
    static boolean[] mainIndicators = new boolean[4];
    static int[] mainIndicatorsx = {740, 880, 1030, 960};

    // research buttons
    static String[] researchButtons = {"button_research_damage", "button_research_hp", "button_research_souls", "button_research_xp", "button_research_enchant"};
    static boolean[] researchIndicators = new boolean[5];
    static int[] researchIndicatorsx = {810, 890, 960, 1040, 1110};
    

    public static void main(String[] args) {
        // start the main loop
        while (running) {
            // track loop time
            long startTime = System.nanoTime();

            // do main loop things
            // find out which things we need to do
            findIndicators();

            // do things
            // handle research
            if (mainIndicators[0] == true) {
                doResearch();
            }
            // handle staff
            if (mainIndicators[1] == true) {
                doStaff();
            }
            // handle eye of vision
            if (mainIndicators[2] == true) {
                doEye();
            }
            // handle enchant
            if (mainIndicators[3] == true) {
                doEnchant();
            }

            // end loop timer
            long endTime = System.nanoTime();
            // get difference
            long timeElapsed = endTime - startTime;
            if (debug) System.out.println("Last main loop took: " + timeElapsed / 1000000 + " milliseconds");
            //if (logLevel > 0) log(Level.INFO, "Last main loop took: " + timeElapsed / 1000000 + " milliseconds");
            running = false;
        }
    }

    private static void doEnchant() {
    }

    private static void doEye() {
    }

    private static void doStaff() {
    }

    // handle research
    private static void doResearch() {
        if (debug) System.out.println("Finding research indicators.");
        // get a screenshot
        Screen s = new Screen();

        try {
            // click on research button
            if (debug) System.out.println("Opening research");
            s.click(imagesPath + "button_research.png");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // first we iterate through all possible research buttons and find out which we can interact with
            for (int i = 0; i < researchButtons.length; i++) {
                s.setROI(researchIndicatorsx[i], 250, 60, 60);
                try {
                    s.find(imagesPath + "indicator.png");
                    researchIndicators[i] = true;
                    if (debug) System.out.println("Indicator found for " + researchButtons[i]);
                } catch (FindFailed e) {
                    researchIndicators[i] = false;
                    if (debug) System.out.println("Indicator not found for " + researchButtons[i]);
                }
            }
        } catch (FindFailed e) {
            if (debug) System.out.println("Couldn't click on research button");
        }

    }

    // run through each of the clickable buttons and find the ones with an indicator on them
    private static void findIndicators() {
        if (debug) System.out.println("Finding indicators.");
        // get a screenshot
        Screen s = new Screen();
        for (int i = 0; i < mainButtons.length; i++) {
            s.setROI(mainIndicatorsx[i], 840, 60, 60);
            try {
                s.find(imagesPath + "indicator.png");
                mainIndicators[i] = true;
                if (debug) System.out.println("Indicator found for " + mainButtons[i]);
            } catch (FindFailed e) {
                mainIndicators[i] = false;
                if (debug) System.out.println("Indicator not found for " + mainButtons[i]);
            }
        }
    }

    private static void log(Level logLevel, String logData) {
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
}