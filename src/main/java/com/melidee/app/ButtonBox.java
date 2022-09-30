package com.melidee.app;

public class ButtonBox {
    private int currentSelect = 0;
    private Tui tui;

    public void attachTui(Tui tuiFrame) {
        tui = tuiFrame;
    }

    public Button[] buttonList = new Button[] {
            new Button(),
            new Button(),
            new Button(),
    };

    public String[] getButtons() {
        return new String[] {
                String.format("  %s  %s  %s ",
                        buttonList[0].getButton()[0],
                        buttonList[1].getButton()[0],
                        buttonList[2].getButton()[0]),
                String.format("  %s  %s  %s ",
                        buttonList[0].getButton()[1],
                        buttonList[1].getButton()[1],
                        buttonList[2].getButton()[1]),
                String.format("  %s  %s  %s ",
                        buttonList[0].getButton()[2],
                        buttonList[1].getButton()[2],
                        buttonList[2].getButton()[2]),
                String.format("  %s  %s  %s ",
                        buttonList[0].getButton()[3],
                        buttonList[1].getButton()[3],
                        buttonList[2].getButton()[3]),
        };
    }

    public void selectButton(int index) {
        for (int i = 0; i < 3; i++) {
            if (buttonList[i].isSelected() && i != index) {
                buttonList[i].deselect();
            } else if (!buttonList[i].isSelected() && i == index) {
                buttonList[i].select();
                currentSelect = i;
            }
        }
    }

    public void setButtonText(String[] newText) {
        for (int i = 0; i < 3; i++) {
            buttonList[i].setText(newText[i]);
        }
        selectButton(0);
        tui.print();
    }

    public void clearButtonText() {
        for (int i = 0; i < 3; i++) {
            buttonList[i].clearText();
            buttonList[i].deselect();
        }
    }

    public void moveLeft() {
        if (currentSelect != 0) {
            selectButton(currentSelect - 1);
        } else {
            selectButton(2);
        }
    }

    public void moveRight() {
        if (currentSelect != 2) {
            selectButton(currentSelect + 1);
        } else {
            selectButton(0);
        }
        
    }

    public int readInput() {
        String c; 
        while (true) {
            c = Helpers.sc.nextLine();
            if (c.equals("z")) {
                moveLeft();
                
            } else if (c.equals("x")) {
                moveRight();
            } else if (c.equals(" ")) {
                return currentSelect;
            }
            tui.print();
            System.out.print("\r\033[K");
        }

    }
}
