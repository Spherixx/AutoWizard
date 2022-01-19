package com.github.spherixx.autowizard;

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

    // bot stuff
    public static String imagesPath = "C:/Users/Spherix/AutoWizard/images/";

    // no
    public static String currentScreen = "none";
    public static boolean onResearchScreen = false;

    // main buttons
    public static String[] mainButtons = {"button_research", "button_staff", "button_eye", "button_enchant"};
    public static boolean[] mainIndicators = new boolean[4];
    public static int[] mainIndicatorsx = {740, 880, 1030, 960};

    // research buttons
    public static String[] researchButtons = {"button_research_damage", "button_research_hp", "button_research_souls", "button_research_xp", "button_research_enchant"};
    public static Boolean[] researchIndicators = new Boolean[5];
    public static int[] researchIndicatorsx = {810, 890, 960, 1040, 1110};
    public static int[] researchButtonsx = {775, 848, 922, 996, 1070};
}
