package com.github.spherixx.autowizard;

import java.awt.AWTException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Research {

    public static void findResearchIndicators() throws FindFailed {
        if (Config.debug) System.out.println("Finding research indicators");
        // make sure we're on research screen
        try {
            util.currentWindow("close");
        } catch (AWTException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // get a screenshot
        Screen s = new Screen();

        // iterate through all possible research buttons and find the ones with indicators
        for (int i = 0; i < Config.researchButtons.length; i++) {
            s.setROI(Config.researchIndicatorsx[i], 250, 60, 60);
            try {
                s.find(Config.imagesPath + "indicator.png");
                Config.researchIndicators[i] = true;
                if (Config.debug) System.out.println("Indicator found for " + Config.researchButtons[i]);
            } catch (FindFailed e) {
                Config.researchIndicators[i] = false;
                if (Config.debug) System.out.println("Indicator not found for " + Config.researchButtons[i]);
            }
        }
    }
    
    public static void handleResearch() throws FindFailed {
        if (Config.debug) System.out.println("Finding research states");
        // make sure we're on research screen
        try {
            util.currentWindow("research");
        } catch (AWTException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // get a screenshot
        Screen s = new Screen();

        // iterate through research buttons checking their state
        for (int i = 0; i < Config.researchButtons.length; i++) {
            if (Config.researchIndicators[i] == true) {
                s.setROI(Config.researchButtonsx[i], 252, 12, 12);
                try {
                    s.find(Config.imagesPath + "research_state_inprogress.png");
                    if (Config.debug) System.out.println(Config.researchButtons[i] + " research in progress");
                } catch (FindFailed e) {}
                try {
                    s.find(Config.imagesPath + "research_state_finished");
                    try {
                        s.setROI(890, 510, 140, 60);
                        s.click(Config.imagesPath + "button_research_acquire.png");
                    } catch (FindFailed e) {}
                    if (Config.debug) System.out.println(Config.researchButtons[i] + " research is finished");
                } catch (FindFailed e) {}
            } else {
                try {
                    s.setROI(890, 510, 140, 60);
                    s.click(Config.imagesPath + "button_research_research.png");
                } catch (FindFailed e) {}
                if (Config.debug) System.out.println(Config.researchButtons[i] + " research started");
            }
        }
    }
}
