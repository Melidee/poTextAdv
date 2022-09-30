package com.melidee.app;
import org.apache.commons.lang3.StringUtils;

public class Player {

    private int health = 75;
    private int wood = 0;
    private int boats = 0;
    private int swords = 0;

    public Player() {
        wood += Helpers.randomInt(0, 12);
    }

    public int getHealth() {
        return health;
    }

    public boolean damage(int damage) {
        health -= damage;
        if (health <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public void heal(int healAmount) {
        health += healAmount;
    }

    public int getWood() {
        return wood;
    }

    public void makeBoat() {
        wood -= 7;
        boats++;
    }

    public boolean getHasBoat() {
        return boats > 0;
    }

    public void makeSword() {
        wood -= 3;
        swords++;
    }

    public boolean getHasSword() {
        return swords > 0;
    }

    public String getHealthBar() {
        int n = health / 10;
        return StringUtils.repeat("▓", n) + StringUtils.repeat("░", 10-n);
    }
}