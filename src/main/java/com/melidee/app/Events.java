package com.melidee.app;

public class Events {

    public static void title() {
        String[] titleLines = new String[] {
                "┌──────────────────────────────────────────────────────────────┐",
                "│ ______       _   _                                  _        │",
                "│ | ___ \\     | | | |         # Throwback            | |       │",
                "│ | |_/ /__   | |_| |__   ___   _ __   __ _ _ __   __| | __ _  │",
                "│ |  __/ _ \\  | __| '_ \\ / _ \\ | '_ \\ / _` | '_ \\ / _` |/ _` | │",
                "│ | | | (_) | | |_| | | |  __/ | |_) | (_| | | | | (_| | (_| | │",
                "│ \\_|  \\___/   \\__|_| |_|\\___| | .__/ \\__,_|_| |_|\\__,_|\\__,_| │",
                "│                              | |                             │",
                "│    A Text Adventure          |_|   By Olivia B and Amelia W  │",
                "└──────────────────────────────────────────────────────────────┘"
        };
        for (String line : titleLines) {
            Helpers.timerPrint(line, 50);
        }
        Helpers.enterPrint("Press Enter to Continue");
    }

    public static void win(TextBox textBox) {
        textBox.clearText();
        textBox.timerPrint("__   __            _    _ _       ", 50);
        textBox.timerPrint("\\ \\ / /           | |  | (_)      ", 50);
        textBox.timerPrint(" \\ V /___  _   _  | |  | |_ _ __  ", 50);
        textBox.timerPrint("  \\ // _ \\| | | | | |/\\| | | '_ \\ ", 50);
        textBox.timerPrint("  | | (_) | |_| | \\  /\\  / | | | |", 50);
        textBox.timerPrint("  \\_/\\___/ \\__,_|  \\/  \\/|_|_| |_|", 50);
    }

    public static void lose(TextBox textBox) {
        textBox.clearText();
        textBox.timerPrint("__   __            _                    ", 50);
        textBox.timerPrint("\\ \\ / /           | |                   ", 50);
        textBox.timerPrint(" \\ V /___  _   _  | |     ___  ___  ___   ", 50);
        textBox.timerPrint("  \\ // _ \\| | | | | |    / _ \\/ __|/ _ \\ ", 50);
        textBox.timerPrint("  | | (_) | |_| | | |___| (_) \\__ \\  __/ ", 50);
        textBox.timerPrint("  \\_/\\___/ \\__,_| \\_____/\\___/|___/\\___| ", 50);
    }
}
