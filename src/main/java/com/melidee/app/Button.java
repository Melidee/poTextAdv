package com.melidee.app;
import org.apache.commons.lang3.StringUtils;

public class Button {
    private String buttonText = "";
    private boolean isSelected = false;

    public void select() {
        isSelected = true;
    }

    public void deselect() {
        isSelected = false;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setText(String newText) {
        buttonText = newText;
    }

    public void clearText() {
        buttonText = "";
    }

    public String[] getButton() {
        if (isSelected) {
            return new String[] {
                "██████████████ ",
                StringUtils.center(buttonText, 14, "█") + "▒",
                "██████████████▒",
                " ▒▒▒▒▒▒▒▒▒▒▒▒▒▒"
            };
        } else {
            return new String[] {
                "██████████████ ",
                StringUtils.center(buttonText, 14, "█") + " ",
                "██████████████ ",
                "               "
            };
        }
    }
}
