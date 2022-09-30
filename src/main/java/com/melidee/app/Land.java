package com.melidee.app;

class Land {
    private Player po;
    private TextBox textBox;
    private ButtonBox buttonBox;

    public Land(Player poInstance, TextBox tBox, ButtonBox bBox) {
        po = poInstance;
        textBox = tBox;
        buttonBox = bBox;

    }

    public void landWelcome() {
        textBox.blankPrint();
        textBox.timerParagraph(
                "You find yourself in the heart of a lush jungle. The faint sound of rushing water can be heard. Despite the humidity and unfamiliar terrain, You trek through the jungle in hopes of finding the river. After walking for what feels like hours, you come across the waterway. You need a way to get to the other side!",
                2000
        );
        textBox.blankPrint();
        textBox.enterPrint();
    }

    public void landOptions() {
        textBox.clearText();
        textBox.timerPrint("Would you like to:", 250);
        textBox.blankPrint();
        textBox.timerPrint("Craft Something (#SwordOrBoat)", 250);
        textBox.timerPrint("Take a Rest (#NappyPoo)", 250);
        textBox.timerPrint("Skip to crossing the river (#BailOut)", 250);
        textBox.blankPrint();
        textBox.timerPrint("Use Z and X to move and Space to select", 0);
        buttonBox.setButtonText(new String[] {
            "Craft",
            "Rest",
            "Skip",
        });
        int choice = buttonBox.readInput();
        while (true) {
            if (choice == 0) { // if the player wants to craft
                textBox.clearText();
                textBox.timerPrint("You decide to make something with your wood!", 500);
                textBox.enterPrint();
                craftSomething();
                break;
            } else if (choice == 1) { // if the player wants to rest
                po.heal(25);
                textBox.clearText();
                textBox.timerPrint("You take a rest and gain 25 Health!", 500);
                textBox.enterPrint();
                break;
            } else if (choice == 2) { // if the player wants to skip
                textBox.clearText();
                textBox.timerPrint("You are impatient and skip to crossing the river!", 500);
                textBox.enterPrint();
                break;
            }
        }
        textBox.clearText();
        buttonBox.clearButtonText();
    }

    private void craftSomething() {

        int choice;
        boolean firstCycle = true;

        while (true) {
            textBox.clearText();
            if (firstCycle) {
                textBox.timerPrint("Would you like to craft: ", 500);
                firstCycle = false;
            } else {
                textBox.timerPrint("Would you like to craft anything else:", 500);
            }
            textBox.blankPrint();
            textBox.timerPrint("A Sword for 3 wood (#IAmAFighter)", 500);
            textBox.timerPrint("A Boat for 7 wood (#PoolDay)", 500);
            textBox.timerPrint("Continue on (#BooThatIsNotFun)", 500);
            buttonBox.setButtonText(new String[] {
                "Sword",
                "Boat",
                "Continue",
            });

            choice = buttonBox.readInput();

            if (choice == 0) { // if the player wants to craft a sword
                craftSword();
            } else if (choice == 1) { // if the player wants to craft a boat
                craftBoat();
            } else if (choice == 2) { // if the player wants to continue on (#NotFun)
                textBox.clearText();
                textBox.timerPrint("You finish with your crafting", 500);
                textBox.enterPrint();
                break;
            }
        }
        textBox.clearText();
        buttonBox.clearButtonText();
    }

    private void craftSword() {
        if (po.getWood() >= 3 && !po.getHasSword()) {
            po.makeSword();
            textBox.clearText();
            textBox.timerPrint("You obtain a sword! (#Slay)", 500);
            textBox.enterPrint();
        } else if (po.getHasSword()) {
            textBox.clearText();
            textBox.timerPrint("You already have a sword (#WayToGo)", 500);
            textBox.enterPrint();
        } else {
            textBox.clearText();
            textBox.timerPrint("You do not have enough wood to make a Sword (#AwMan)", 500);
            textBox.enterPrint();
        }
    }

    private void craftBoat() {
        if (po.getWood() >= 7 && !po.getHasBoat()) {
            po.makeBoat();
            textBox.clearText();
            textBox.timerPrint("You obtain a boat! (#Slay)", 500);
            textBox.enterPrint();
        } else if (po.getHasBoat()) {
            textBox.clearText();
            textBox.timerPrint("You already have a sword (#WayToGo)", 500);
            textBox.enterPrint();
        } else {
            textBox.clearText();
            textBox.timerPrint("You do not have enough wood to make a Boat (#AwMan)", 500);
            textBox.enterPrint();
        }
    }
}