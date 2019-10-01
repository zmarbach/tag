package org.improving.tag;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleInputOutput implements InputOutput {
    private Scanner scanner;

    public ConsoleInputOutput (Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String receiveInput() {
        return scanner.nextLine();
        /// you need to do something in the program after this response
    }

    @Override
    public void displayText(Object text) {//played with this one to demonstrate toString
        if (!"".equals(text.toString())) {//have to toString it to turn the Object text into a String
            System.out.println(text);
        } //else it does what is outside the if...which is nothing
    }

    @Override
    public void displayNewLine() {
        System.out.println();
    }

    @Override
    public void displayPrompt(String prompt) {
        System.out.print(prompt);
    }

}
