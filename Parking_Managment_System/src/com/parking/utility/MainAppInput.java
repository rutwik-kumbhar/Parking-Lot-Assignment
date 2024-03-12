package com.parking.utility;

import java.util.Scanner;

public class MainAppInput {

    public static Scanner getScannerClass() {
        return new Scanner(System.in);
    }


    public static void appMenu() {
        String operations = """
                1. You Want to Perform Floor Related Operation Press 1  \s
                2. You  Want to Perform Park Related Operations Press 2\s
                3. Close Application Press  3 \s
                """;
        System.out.println(operations);

    }
}
