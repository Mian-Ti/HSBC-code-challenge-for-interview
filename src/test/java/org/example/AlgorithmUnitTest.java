package org.example;

import jdk.jfr.Description;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlgorithmUnitTest {
    @Test
    @Description("Test normal requirement")
    public void testNormalRequirement() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        AlgorithmStack stack = new AlgorithmStack();
        String testString = "aabcccbbad";
        Character[] characterArray = Utils.StringToCharacterArray(testString);

        for (int i= 0; i < characterArray.length; i++) {
            String trailing = testString.substring(i+1);
            stack.setTrailing(trailing);
            stack.pushStack(characterArray[i]);
        }

        String consoleOutput = outputStream.toString().trim();

        Assert.assertEquals("""
                -> aabbbad
                -> aaad
                -> d""", consoleOutput);

        System.setOut(originalOut);
    }

    @Test
    @Description("Test advanced requirement")
    public void testAdvancedRequirement() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        AlgorithmStack stack = new AlgorithmStack(true);
        String testString = "abcccbad";
        Character[] characterArray = Utils.StringToCharacterArray(testString);

        for (int i= 0; i < characterArray.length; i++) {
            String trailing = testString.substring(i+1);
            stack.setTrailing(trailing);
            stack.pushStack(characterArray[i]);
        }

        String consoleOutput = outputStream.toString().trim();

        Assert.assertEquals("""
                -> abbbad, ccc is replaced by b
                -> aaad, bbb is replaced by a
                -> d""", consoleOutput);

        System.setOut(originalOut);
    }
}
