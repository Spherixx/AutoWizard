package com.github.spherixx.autowizard;

import java.awt.AWTException;
import org.sikuli.script.FindFailed;

public class EyeofVision {

    public static void handleEye() throws FindFailed, AWTException {
        if (Config.debug) System.out.println("Activating Eye of Vision");
        util.currentWindow("eye");
        util.sleep(500);
        util.mouseInput("click", Config.eyeButtonXY[0], Config.eyeButtonXY[1]);
        util.sleep(250);
    }
}
