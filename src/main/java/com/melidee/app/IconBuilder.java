package com.melidee.app;


import java.util.EnumMap;

public class IconBuilder {
    private static Levels healthLevel;
    private Player po;

    private enum Levels {
        HIGH,
        NORMAL,
        LOW,
        NONE
    }

    public IconBuilder(Player poInstance) {
        po = poInstance;
    }

    public String[] getIcon() {
        setIcon(po.getHealth());
        return icons.get(healthLevel);
    }
    
    public void setIcon(int health) {
        if (health == 100) {
            healthLevel = Levels.HIGH;
        } else if (health > 50) {
            healthLevel = Levels.NORMAL;
        } else if (health > 0) {
            healthLevel = Levels.LOW;
        } else {
            healthLevel = Levels.NONE;
        }
    }

    private EnumMap<Levels, String[]> icons = new EnumMap<Levels, String[]>(Levels.class) {{
        put(Levels.HIGH, new String[] {
            Helpers.invertText("               "),
            Helpers.invertText("    ●◜ ¯◝ ●    "),
            Helpers.invertText("    (♥ ☂ ♥)    "),
            Helpers.invertText("     ▀███▀     "),
            Helpers.invertText("    ●(¯¯¯)     "),
            Helpers.invertText("     ▄█¯█▄     "),
            Helpers.invertText("               "),
        });

        put(Levels.NORMAL, new String[] {
            Helpers.invertText("               "),
            Helpers.invertText("    ●◜ ¯◝ ●    "),
            Helpers.invertText("    (● ☂ ●)    "),
            Helpers.invertText("     ▀███▀     "),
            Helpers.invertText("    ●(¯¯¯)     "),
            Helpers.invertText("     ▄█¯█▄     "),
            Helpers.invertText("               "),
        });

        put(Levels.LOW, new String[] {
            Helpers.invertText("               "),
            Helpers.invertText("    ●◜¯¯◝ ●    "),
            Helpers.invertText("    ( ●☂= )    "),
            Helpers.invertText("     ▀███▀     "),
            Helpers.invertText("    ●(¯¯¯)     "),
            Helpers.invertText("      █¯█▄     "),
            Helpers.invertText("               "),
        });

        put(Levels.NONE, new String[] {
            Helpers.invertText("               "),
            Helpers.invertText("    ●◜¯¯◝ ●    "),
            Helpers.invertText("    ( X☂X )    "),
            Helpers.invertText("      ███      "),
            Helpers.invertText("     (¯¯¯)     "),
            Helpers.invertText("      █¯█      "),
            Helpers.invertText("               "),
        });
    }};
}
