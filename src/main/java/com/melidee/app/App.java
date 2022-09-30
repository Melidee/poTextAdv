package com.melidee.app;

public class App {

    private static Player po = new Player();
    private static TextBox textBox = new TextBox();
    private static ButtonBox buttonBox = new ButtonBox();
    private static Land land = new Land(po, textBox, buttonBox);
    private static River river = new River(po, textBox, buttonBox);
    private static Fight fight = new Fight(po, textBox, buttonBox);
    private static IconBuilder iconBuilder = new IconBuilder(po);
    
    private static Tui tui = new Tui(iconBuilder, buttonBox, textBox, po);

    public static void main(String[] args) {
        textBox.attachTui(tui);
        buttonBox.attachTui(tui);
        Helpers.clearScreen();
        Events.title();
        
        // round 1: land
        Helpers.clearScreen();
        land.landWelcome();
        land.landOptions();
        
        // round 2: river
        Helpers.clearScreen();
        river.riverWelcome();
        river.riverOptions();

        // round 3: fight (a bat)
        Helpers.clearScreen();
        fight.fightWelcome();
        fight.fightOptions();
        
    }
}