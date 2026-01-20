package org.example.jclo_2026_02;

import java.util.logging.Logger;

public class ProductionProfile implements SystemProfile{
    @Override
    public String getProfile() {
        System.out.println("Current profile is production");
        Logger.getLogger("system log").info("Current profile is production");
        return "Current profile is production";
    }
}
