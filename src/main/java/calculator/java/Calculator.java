package calculator.java;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Calculator {

    private static final String WARN_MESSAGE = "Your number should be more or equal to -20, and less or equal than 20. " +
            "Please enter a correct number";

    public static void main(String[] args) throws IOException {
        Session session = new Session();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name please ");
        session.setUserName(scanner.nextLine());

        boolean recoursion = true;

        System.out.print(session.getUserName() + ", nice to meet you! Enter 1st number:");
        session.setFirst(scanner.nextFloat());
        do {
            if (session.getFirst() > 20 || session.getFirst() < -20) {
                System.out.println(WARN_MESSAGE);
                session.setFirst(scanner.nextFloat());
            } else {
                System.out.println("You selected correct first number.");
            }
        }
        while (session.getFirst() > 20 || session.getFirst() < -20);

        System.out.print("Enter 2d number:");
        session.setSecond(scanner.nextFloat());
        do {
            if (session.getSecond() > 20) {
                System.out.println(WARN_MESSAGE);
                session.setSecond(scanner.nextFloat());
            } else if (session.getSecond() < -20) {
                System.out.println(WARN_MESSAGE);
                session.setSecond(scanner.nextFloat());
            } else
                System.out.println("You selected correct second number. ");
        }
        while (session.getSecond() > 20 || session.getSecond() < -20);

        while (recoursion) {
            recoursion = false;
            System.out.println("Please select math operation: +,-,*,/ ");
            session.setAction((char) System.in.read());

            switch (session.getAction()) {
                case '+':
                    printAndSaveResult(session.getFirst() + session.getSecond());
                    break;
                case '-':
                    printAndSaveResult(session.getFirst() - session.getSecond());
                    break;
                case '*':
                    printAndSaveResult(session.getFirst() * session.getSecond());
                    break;
                case '/':
                    printAndSaveResult(session.getFirst() / session.getSecond());
                    break;
                default:
                    System.out.println("You selected an incorrect math operation. ");
                    recoursion = true;
            }

            System.out.println("Would you like to continue calculation with another math operation? 1 Yes / 2 No");
            float first, second, further;
            further = scanner.nextFloat();
            if (further == 1)
                recoursion = true;
            else if (further == 2)
                recoursion = false;
            else
                System.out.println("You should be attentive");

            if (further == 2)
                System.out.println("Thank you. See you later");
        }
    }

    private static void printAndSaveResult(float result) {
        System.out.println("Your result is:" + result);

        try (FileWriter writeToFile = new FileWriter("calculation_results.txt", true)) {
            String text = "\n Result of your calculation is:" + result + "\t" + new Date();
            writeToFile.write(text);
            writeToFile.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

