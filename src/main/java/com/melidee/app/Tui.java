package com.melidee.app;
public class Tui {
    private IconBuilder iconBuilder;
    private ButtonBox buttonBox;
    private TextBox textBox;
    private Player po;

    private String[] buttons;
    private String[] icon;
    private String[] textBody;
    private int boats;
    private int swords;

    public Tui(IconBuilder iBuilder, ButtonBox bBox, TextBox tBox, Player poInstance) {
        iconBuilder = iBuilder;
        buttonBox = bBox;
        textBox = tBox;
        po = poInstance;
    }

    private void updateFrame() {
        icon = iconBuilder.getIcon();
        buttons = buttonBox.getButtons();
        textBody = textBox.getText();
    }

    public void print() {
        updateFrame();
        System.out.print("\033[2J");
        System.out.println(
            String.format("┌───────────────┬────────────────────────────────────────────────────┐\n") +
            String.format("│%s│ %s │\n", icon[0], textBody[0]) +
            String.format("│%s│ %s │\n", icon[1], textBody[1]) +
            String.format("│%s│ %s │\n", icon[2], textBody[2]) +
            String.format("│%s│ %s │\n", icon[3], textBody[3]) +
            String.format("│%s│ %s │\n", icon[4], textBody[4]) +
            String.format("│%s│ %s │\n", icon[5], textBody[5]) +
            String.format("│%s│ %s │\n", icon[6], textBody[6]) +
            String.format("├───────────────┤ %s │\n", textBody[7]) +
            String.format("│               │ %s │\n", textBody[8]) +
            String.format("│  Health: %03d  │ %s │\n", po.getHealth(), textBody[9]) +
            String.format("│  %s   │ %s │\n", po.getHealthBar(), textBody[10]) +
            String.format("│               │ %s │\n", textBody[11]) +
            String.format("│  Inventory:   │                                                    │\n") +
            String.format("│   Wood: %02d    ├────────────────────────────────────────────────────┤\n", po.getWood()) +
            String.format("│   Boats: %d    │%s│\n", boats, buttons[0]) +
            String.format("│   Swords: %d   │%s│\n", swords, buttons[1]) +
            String.format("│               │%s│\n", buttons[2]) +
            String.format("│               │%s│\n", buttons[3]) +
            String.format("└───────────────┴────────────────────────────────────────────────────┘\n")
        );
    }   
}
