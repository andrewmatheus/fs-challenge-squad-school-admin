package utils;

import java.util.Scanner;

public class Scan {
    // <editor-fold desc="Attributes">
    private static Scanner scanner;
    // </editor-fold>

    // <editor-fold desc="methods">

    /**
     * Method initializeScanner - if necessary, initialize a new scanner
     * */
    private static void initializeScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    /**
     * Method next - if necessary, initialize a string scanner
     * */
    public static String next() {
        return nextLine();
    }
    public static String nextLine() {
        initializeScanner();
        return scanner.nextLine();
    }

    /**
     * Method nextInt - if necessary, initialize a int scanner
     * */
    public static int nextInt() {
        initializeScanner();
        String input = scanner.nextLine().strip();
        return Integer.parseInt(input);
    }

    /**
     * Method nextDouble - if necessary, initialize a double scanner
     * */
    public static double nextDouble() {
        initializeScanner();
        String input = scanner.nextLine().strip();
        return Double.parseDouble(input);
    }

    /**
     * Method close - finish scan open
     * */
    public static void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
    // </editor-fold>
}
