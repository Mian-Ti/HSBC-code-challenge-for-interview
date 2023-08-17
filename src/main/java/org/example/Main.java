package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            // this is for normal requirement
            AlgorithmStack stack = new AlgorithmStack();
            String input = scanner.nextLine();
            Character[] characterArray = Utils.StringToCharacterArray(input);

            for (int i= 0; i < characterArray.length; i++) {
                String trailing = input.substring(i+1);
                stack.setTrailing(trailing);
                stack.pushStack(characterArray[i]);
            }

            // this is for advanced requirement
            stack = new AlgorithmStack(true);
            input = scanner.nextLine();
            characterArray = Utils.StringToCharacterArray(input);

            for (int i= 0; i < characterArray.length; i++) {
                String trailing = input.substring(i+1);
                stack.setTrailing(trailing);
                stack.pushStack(characterArray[i]);
            }
        };

    }
}