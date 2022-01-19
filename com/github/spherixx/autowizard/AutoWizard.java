package com.github.spherixx.autowizard;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import java.util.Arrays;


public class AutoWizard {

    // main loop runs while this is true
    private static boolean running = true;

    public static void main(String[] args) {
        // start the main loop
        while (running) {
            // track loop time
            long startTime = System.nanoTime();

            // do main loop things
            // find out which things we need to do
            findIndicators();
            util.getCurrentScreen();

            // do things
            // handle research
            if (Config.mainIndicators[0] == true) {
                Research.findResearchIndicators();
                if (Arrays.asList(Config.researchIndicators).contains(true)) Research.doResearch();
            }
            // handle staff
            if (Config.mainIndicators[1] == true) StaffofKnowledge.handleStaff();
            // handle eye of vision
            if (Config.mainIndicators[2] == true) EyeofVision.handleEye();
            // handle enchant
            if (Config.mainIndicators[3] == true) Enchant.handleEnchant();

            // end loop timer
            long endTime = System.nanoTime();
            // get difference
            long timeElapsed = endTime - startTime;
            if (Config.debug) System.out.println("Last main loop took: " + timeElapsed / 1000000 + " milliseconds");
            //if (logLevel > 0) log(Level.INFO, "Last main loop took: " + timeElapsed / 1000000 + " milliseconds");
            running = false;
        }
    }

    // run through each of the clickable buttons and find the ones with an indicator on them
    private static void findIndicators() {
        if (Config.debug) System.out.println("Finding indicators.");
        // get a screenshot
        Screen s = new Screen();
        for (int i = 0; i < Config.mainButtons.length; i++) {
            s.setROI(Config.mainIndicatorsx[i], 840, 60, 60);
            try {
                s.find(Config.imagesPath + "indicator.png");
                Config.mainIndicators[i] = true;
                if (Config.debug) System.out.println("Indicator found for " + Config.mainButtons[i]);
            } catch (FindFailed e) {
                Config.mainIndicators[i] = false;
                if (Config.debug) System.out.println("Indicator not found for " + Config.mainButtons[i]);
            }
        }
    }

}