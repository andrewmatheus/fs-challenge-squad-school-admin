package utils;

import java.util.Scanner;

public class Scan {
    private static Scanner scanner;

    private static void initializeScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    public static String next() {
        return nextLine();
    }
    public static String nextLine() {
        initializeScanner();
        return scanner.nextLine();
    }

    public static int nextInt() {
        initializeScanner();
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static double nextDouble() {
        initializeScanner();
        double number = scanner.nextDouble();
        scanner.nextLine();
        return number;
    }

    public static void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
