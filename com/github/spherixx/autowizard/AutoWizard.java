package com.github.spherixx.autowizard;

import java.awt.AWTException;
import java.time.LocalTime;
import java.util.Arrays;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class AutoWizard {

    public static void main(String[] args) throws FindFailed, AWTException {
        
        // main loop runs while this is true
        boolean running = true;
        LocalTime lastRun;
        int runCount = 0;

        // start the main loop
        while (running) {
            // track loop time
            long startTime = System.nanoTime();
            // set the last run time
            lastRun = LocalTime.now();

            // do main loop things
            
            // if more than antiAFK time has passed
            if (lastRun.isAfter(lastRun.plus(Config.antiAFK))) {
                antiAFK();
            }

            // find out which things we need to do
            findIndicators();
            util.sleep(250);

            // do things
            // handle research
            if (Config.mainIndicators[0] == true && Config.autoResearch == false) {
                Research.findResearchIndicators();
                if (Arrays.asList(Config.researchIndicators).contains(true)) Research.handleResearch();
                util.sleep(250);
            }
            // handle staff
            if (Config.mainIndicators[1] == true) StaffofKnowledge.handleStaff();
            util.sleep(250);
            // handle eye of vision
            if (Config.mainIndicators[2] == true) EyeofVision.handleEye();
            util.sleep(250);
            // handle enchant
            if (Config.mainIndicators[3] == true) Enchant.handleEnchant();
            util.sleep(250);

            // end loop timer
            long endTime = System.nanoTime();
            // get difference
            long timeElapsed = endTime - startTime;
            if (Config.debug) System.out.println("Last main loop took: " + timeElapsed / 1000000 + " milliseconds");

            runCount++;
            if (runCount >= 10) {
                running = false;
            }
        }
    }

    // run through each of the clickable buttons and find the ones with an indicator on them
    private static void findIndicators() {
        if (Config.debug) System.out.println("Finding indicators.");
        Screen s = new Screen();
        for (int i = 0; i < Config.mainIndicatorButtons.length; i++) {
            s.setROI(Config.mainIndicatorsX[i], 840, 60, 60);
            try {
                s.find(Config.imagesPath + "indicator.png");
                Config.mainIndicators[i] = true;
                if (Config.debug) System.out.println("Indicator found for " + Config.mainIndicatorButtons[i]);
            } catch (FindFailed e) {
                Config.mainIndicators[i] = false;
                if (Config.debug) System.out.println("Indicator not found for " + Config.mainIndicatorButtons[i]);
            }
        }
    }

    private static void antiAFK() throws AWTException {
        int rand = (int) Math.random() * ((4 - 1) + 1) + 1;

        switch (rand) {
            case 1:
                util.mouseInput("click", 301, 204);
            break;
            case 2:
                util.mouseInput("click", 311, 860);
            break;
            case 3:
                util.mouseInput("click", 1650, 240);
            break;
            case 4:
                util.mouseInput("click", 1600, 880);
            break;
        }
    }

}