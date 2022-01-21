package com.github.spherixx.autowizard;

import java.time.Duration;

public class Config {

    // toggles console debugging on or off
    public static boolean debug = true;

    /*
        logLevel
            0: logging off
            1: error logging and minor info logging
            2: error logging and all info logging
    */
    public static int logLevel = 0;

    // path stuff
    // TODO: hardcoded paths are a no no 
    public static String imagesPath = "C:/Users/Spherix/AutoWizard/images/";
    public static String spellImagesPath = "C:/Users/Spherix/AutoWizard/images/spells/";

    // anti afk click timer (it won't always click exactly at this interval)
    public static int antiAFK = 10000;
    
    // true if using auto research perk, false if bot is handling research
    public static boolean autoResearch = true;

    // main buttons
    public static int[] mainButtonsX = {740, 810, 880, 960, 1030, 1100, 1180};
    public static int[] mainButtonsY = {800, 880, 960};

    public static String[] mainIndicatorButtons = {"button_research", "button_staff", "button_eye", "button_enchant"};
    public static boolean[] mainIndicators = new boolean[4];
    public static int[] mainIndicatorsX = {740, 880, 1030, 960};

    // eye buttons
    public static int[] eyeButtonXY = {1100, 320};

    // enchant buttons
    public static int[] enchantButtonXY = {960, 500};

    // research buttons
    public static String[] researchButtons = {"button_research_damage", "button_research_hp", "button_research_souls", "button_research_xp", "button_research_enchant"};
    public static Boolean[] researchIndicators = new Boolean[5];
    public static int[] researchIndicatorsx = {810, 890, 960, 1040, 1110};
    public static int[] researchButtonsx = {775, 848, 922, 996, 1070};

    // staff buttons
    public static int[] staffButtonsX = {851, 925, 999};
    public static int staffButtonsY = 300;


    // testing
    public static boolean staff = true;
    public static boolean eye = true;
    public static boolean enchant = true;

}
