package org.improving.tag;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim()
            if (input.equals("look")) {
                System.out.println("You look around.");
            }
            if (input.equals("inventory")){
                System.out.println("You are carrying nothing.");
            }
            if (input.equals("dance")) {
                System.out.println("You dance around.");
            }
            if (input.equals("jump")) {
                System.out.println("You jump in the air.");
            }
        }
    }
}
