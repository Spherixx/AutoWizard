package com.github.spherixx.autowizard;

import java.awt.AWTException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Enchant {

    private static boolean enchant;

    public static void getEnchantLevel() {
        Screen s = new Screen();
        s.setROI(933, 892, 55, 32);
        try {
            s.findText("+20");
            s.findText("+21");
            s.findText("+22");
            s.findText("+23");
            s.findText("+24");
            s.findText("+25");
            s.findText("20");
            s.findText("21");
            s.findText("22");
            s.findText("23");
            s.findText("24");
            s.findText("25");
            enchant = true;
            if (Config.debug) System.out.println("Enchant Necessary");
            util.sleep(500);
        } catch (FindFailed e) {
            enchant = false;
        }
    }

    public static void handleEnchant() throws FindFailed, AWTException {

        if (enchant == true) {
            if (Config.debug) System.out.println("Enchanting");
            util.currentWindow("enchant");
            util.sleep(500);
            util.mouseInput("click", Config.enchantButtonXY[0], Config.enchantButtonXY[1]);
            util.sleep(250);
        }
    }

}
