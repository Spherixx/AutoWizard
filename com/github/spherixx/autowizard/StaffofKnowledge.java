package com.github.spherixx.autowizard;

import java.awt.AWTException;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class StaffofKnowledge {

    private static boolean[] foundSpell = {false, false, false};

    public static void handleStaff() throws AWTException, FindFailed {
        findPerkChoice();
        
        Screen s = new Screen();
        s.setROI(680, 770, 570, 300);

        if (foundSpell[0] == true) {
            util.mouseInput("click", Config.staffButtonsX[0], Config.staffButtonsY);
            s.click(Config.imagesPath + "button_staff_select.png");
        } else if (foundSpell[1] == true) {
            util.mouseInput("click", Config.staffButtonsX[1], Config.staffButtonsY);
            s.click(Config.imagesPath + "button_staff_select.png");
        } else if (foundSpell[2] == true) {
            util.mouseInput("click", Config.staffButtonsX[2], Config.staffButtonsY);
            s.click(Config.imagesPath + "button_staff_select.png");
        }

        util.sleep(250);
        
    }

    public static void findPerkChoice() throws FindFailed, AWTException {
        util.currentWindow("staff");
        util.sleep(500);
        Screen s = new Screen();

        // check each one of the perk options
        for (int i = 0; i > foundSpell.length; i++) {
            if (i == 0) {
                if (Config.debug) System.out.println("Checking first slot");
                s.setROI(850, 299, 72, 72);
            } else if (i == 1) {
                s.setROI(924, 299, 72, 72);
                if (Config.debug) System.out.println("Checking second slot");
            } else if (i == 2) {
                s.setROI(998, 299, 72, 72);
                if (Config.debug) System.out.println("Checking third slot");
            }
            try {
                s.find(Config.imagesPath + "spells/spell_firestream.png");
                foundSpell[i] = true;
                if (Config.debug) System.out.println("Found spell_firestream");
                break;
            } catch (FindFailed e) {
                foundSpell[i] = false;
            }
            try {
                s.find(Config.imagesPath + "spells/spell_shardbolter.png");
                foundSpell[i] = true;
                if (Config.debug) System.out.println("Found spell_shardbolter");
                break;
            } catch (FindFailed e) {
                foundSpell[i] = false;
            }
            try {
                s.find(Config.imagesPath + "spells/spell_winterscoil.png");
                foundSpell[i] = true;
                if (Config.debug) System.out.println("Found spell_winterscoil");
                break;
            } catch (FindFailed e) {
                foundSpell[i] = false;
            }
            try {
                s.find(Config.imagesPath + "spells/spell_fierydeluge.png");
                foundSpell[i] = true;
                if (Config.debug) System.out.println("Found spell_fierydeluge");
                break;
            } catch (FindFailed e) {
                foundSpell[i] = false;
            }
        }
    }
}