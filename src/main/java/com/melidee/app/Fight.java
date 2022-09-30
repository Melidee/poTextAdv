package com.melidee.app;
class Fight {

    private TextBox textBox;
    private ButtonBox buttonBox;
    private Player po;
    private int sword;
    private int hands;

    public Fight(Player poInstance, TextBox tBox, ButtonBox bBox) {
        po = poInstance;
        sword = Helpers.randomInt(20, 40);
        hands = Helpers.randomInt(20, 80);
        textBox = tBox;
        buttonBox = bBox;
    }

    public void fightWelcome() {
        textBox.timerParagraph(
            "You've made across the river (#yay)! After that harrowing, near-death experience, you are tired and ready for a nice, warm, home-cooked meal. Unfortunately, that's not what you get... \n Instead, while fantasizing about food, you get caught offguard by a viciously rabid bat flying around your head. You have a terrible irrational fear of bats (#awkward...), but you are in Survival Mode.",
            2000
        );
        textBox.enterPrint();
    }

    public void fightOptions() {
        textBox.clearText();
        textBox.timerPrint("Would you like to: ", 500);
        textBox.timerPrint("(F): Fight the bat (#CashMeOutside)", 500);
        textBox.timerPrint("(R): Run Away from the bat (#TakeYourChances)", 500);
        textBox.timerPrint("(G): Give up and die :/", 500);

        buttonBox.setButtonText(new String[] {
            "Fight",
            "Run",
            "Give Up",
    });

        int choice;
        while (true) {
            choice = buttonBox.readInput();
            if (choice == 0) {
                textBox.clearText();
                textBox.timerPrint("You decide to fight the bat", choice);
                textBox.enterPrint();
                fight();
                break;
            }

            else if (choice == 1) {
                textBox.clearText();
                textBox.timerPrint("You decide to run from the bat", choice);
                textBox.enterPrint();
                runAway();
                break;
            }

            else if (choice == 2) {
                textBox.clearText();
                textBox.timerPrint("You decide to give up", choice);
                textBox.enterPrint();
                giveUp();
                break;
            }
        }
    }

    public void fight() {
        if (po.getHasSword()) {
            if (po.damage(sword)) {
                textBox.clearText();
                Helpers.timerPrint("You killed the bat!", 500);
                textBox.enterPrint();
                Events.win(textBox);
            } else {
                textBox.clearText();
                textBox.timerPrint("The bat got you! (#HowDidYouManageThat)", 500);
                textBox.enterPrint();
                Events.lose(textBox);
            }
        } else {
            if (po.damage(hands)) {
                textBox.clearText();
                textBox.timerPrint("You killed the bat!", 500);
                textBox.enterPrint();
                Events.win(textBox);
            } else {
                textBox.clearText();
                textBox.timerPrint("The bat got you! (#HowDidYouManageThat)", 500);
                textBox.enterPrint();
                Events.lose(textBox);
            }
        } 
    }

    public void runAway() {
        boolean fast = Helpers.randomBool();
        if (fast) {
            textBox.clearText();
            textBox.timerPrint("You ran away from the bat successfully :)", hands);
            textBox.enterPrint();
            Events.win(textBox);
        } else {
            textBox.clearText();
            textBox.timerPrint("The bat caught you! (#HowDidYouManageThat)", 500);
            textBox.enterPrint();
            Events.lose(textBox);
        }
    }

    public void giveUp() {
        textBox.clearText();
        textBox.timerPrint("Never give up on yourself...", 500);
        textBox.enterPrint();
        Events.lose(textBox);
    }
}