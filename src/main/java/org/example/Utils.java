package org.example;

public class Utils {
    public static Character[] StringToCharacterArray(String input) {
        char[] charArray = input.toCharArray();
        Character[] characterArray = new Character[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            characterArray[i] = charArray[i];
        }
        return characterArray;
    }
}
