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
    public void displayText(String text) {
        System.out.println(text);
        // dont have to do anything back in the program after this, just give the output to the console and wait.
    }

    @Override
    public void displayPrompt(String prompt) {
        System.out.print(prompt);
    }

}
