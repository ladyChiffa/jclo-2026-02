package org.example.jclo_2026_02;

import java.util.logging.Logger;

public class DevProfile implements SystemProfile{
    @Override
    public String getProfile() {
        System.out.println("Current profile is dev");
        Logger.getLogger("system log").info("Current profile is dev");
        return "Current profile is dev";
    }
}
