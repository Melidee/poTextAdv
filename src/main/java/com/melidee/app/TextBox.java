package com.melidee.app;

import org.apache.commons.lang3.StringUtils;
import org.davidmoten.text.utils.WordWrap;

public class TextBox {
    private String[] lines;
    private Tui tui;
    private String blankLine = StringUtils.repeat(" ", 50);

    public TextBox() {
        lines = new String[] {
                blankLine,
                blankLine,
                blankLine,
                blankLine,
                blankLine,
                blankLine,
                blankLine,
                blankLine,
                blankLine,
                blankLine,
                blankLine,
                blankLine,
        };
    }

    public void attachTui(Tui t) {
        tui = t;
    }

    private void pushStr(String n) {
        for (int i = 0; i < 11; i++) {
            lines[i] = lines[i + 1];
        }
        lines[11] = n;
    }

    public String[] getText() {
        return lines;
    }

    public void clearText() {
        for (int i = 0; i <= 11; i++) {
            lines[i] = blankLine;
        }
    }

    public void timerParagraph(String str, int millis) {
        String wrapped = WordWrap.from(str)
                .maxWidth(50)
                .newLine("~")
                .insertHyphens(true) // true is the default
                .wrap();
        String[] strs = wrapped.split("~");
        for (String string : strs) {
            pushStr(StringUtils.rightPad(string, 50, " "));
            tui.print();
            Helpers.sleep(millis);
        }
    }

    public void timerPrint(String str, int millis) {
        pushStr(StringUtils.rightPad(str, 50, " "));
        tui.print();
        Helpers.sleep(millis);
    }

    public void enterPrint() {
        pushStr(StringUtils.rightPad("Press Enter to Continue.", 50, " "));
        tui.print();
        Helpers.sc.nextLine();
    }

    public void blankPrint() {
        pushStr(blankLine);
        tui.print();
    }
}
