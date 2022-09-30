package com.melidee.app;

import java.util.Scanner;

public final class Helpers {
    public static Scanner sc = new Scanner(System.in);

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String invertText(String str) {
        return "\33[38;5;0;48;5;255m" + str + "\33[m";
    }

    public static int randomInt(int min, int max) {
        int range = max - min + 1;
        return (int) (Math.random() * range + min);
    }

    public static boolean randomBool() {
        double n = Math.random();
        if (n > 0.5) {
            return true;
        } else {
            return false;
        }
    }

    public static void timerPrint(String str, Integer millis) {
        System.out.println(str);
        sleep(millis);
    }

    public static void enterPrint(String str) {
        System.out.print(str);
        sc.nextLine();
    }

    

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            
        }
    }
}