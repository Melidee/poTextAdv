package com.melidee.app;

class River {
    private TextBox textBox;
    private Player po;
    private ButtonBox buttonBox;
    private int acidity = Helpers.randomInt(20, 50);
    private boolean bridgeExists = Helpers.randomBool();

    public River(Player poInstance, TextBox tBox, ButtonBox bBox) {
        po = poInstance;
        bridgeExists = Helpers.randomBool();
        textBox = tBox;
        buttonBox = bBox;
    }

    public void riverWelcome() {
        textBox.timerParagraph(
            "The river in front of you looks watery(#TechnicalTerm). You can see fish swimming urgently through the clear water. Sunbathing on a rock near the bank is a turtle. On the other side of the river, you see something that makes you want to cross it (#UseYourImagination)",
            2000
        );
        textBox.blankPrint();
        textBox.enterPrint();
    }

    public void riverOptions() {
        int choice;
        while (true) {
            textBox.clearText();
            textBox.timerPrint("Would you like to: ", 500);

            textBox.timerPrint("Wade through the river (WhatAreYou'Wade'ingFor", 250);
            textBox.timerPrint("Boat across the river (#FerryFun)", 250);
            textBox.timerPrint("Try to find a bridge (#TakeALook)", 250);

            buttonBox.setButtonText(new String[] {
                "Wade",
                "Boat",
                "Find Bridge",
            });

            choice = buttonBox.readInput();
            if (choice == 0) { // wade across
                textBox.clearText();
                textBox.timerPrint("You wade across the river", 250);
                if (!po.damage(acidity)) {
                    Events.lose(textBox);
                }
                textBox.timerPrint("You took " + acidity + " damage", 250);
                textBox.enterPrint();
                break;
            } else if (choice == 1) { // boat across
                if (po.getHasBoat()) {
                    textBox.clearText();
                    textBox.timerPrint("You are able to float across the river in your boat", 500);
                    textBox.enterPrint();
                    break;
                } else {
                    textBox.clearText();
                    textBox.timerPrint("You do not have a boat! You cannot boat across the river :(", 500);
                    textBox.enterPrint();
                }
            } else if (choice == 2) {
                if (bridgeExists) {
                    bridgeRiver();
                    break;
                } else {
                    textBox.clearText();
                    textBox.timerPrint("You are unable to find a bridge :(", 500);
                    textBox.enterPrint();
                }
            }
        }
        textBox.clearText();
        buttonBox.clearButtonText();
    }

    private void bridgeRiver() {
        boolean chance1 = Helpers.randomBool();
        boolean chance2 = Helpers.randomBool();
        if (chance1 || chance2) { // if crossing the bridge is successful
            textBox.clearText();
            textBox.timerPrint("You found a bridge and crossed it successfully", 500);
            textBox.enterPrint();

        } else { // if crossing the bridge fails
            textBox.clearText();
            textBox.timerPrint("The bridge broke when you crossed it (#Awkward)", 250);
            if (!po.damage(acidity)) {
                Events.lose(textBox);
            }
            textBox.timerPrint("You took " + acidity + " damage", 250);
            textBox.enterPrint();
        }
    }
}