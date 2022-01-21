package com.github.spherixx.autowizard;

import java.awt.AWTException;
import org.sikuli.script.FindFailed;

public class EyeofVision {

    public static void handleEye() throws FindFailed, AWTException {
        util.currentWindow("eye");
        util.mouseInput("click", Config.eyeButtonXY[0], Config.eyeButtonXY[1]);
    }
}
