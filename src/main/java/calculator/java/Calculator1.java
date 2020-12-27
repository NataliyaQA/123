package calculator.java;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) throws IOException {
        Scanner string = new Scanner(System.in);
        System.out.print("Enter your name please ");
        System.out.print(string.nextLine());

        Scanner number = new Scanner(System.in);
        float first, second, further;
        float result = 0;
        boolean recoursion = true;
        char action;

        System.out.print(", nice to meet you! Enter 1st number:");
        first = number.nextFloat();
        do {
            if (first >20 || first <-20) {
                System.out.println("Your number should be more or equal to -20, and less or equal than 20. Please enter a correct number");
                first = number.nextFloat();
            }
            else{
                System.out.println("You selected correct first number.");
            }
        }
        while (first >20 || first <-20);

        System.out.print("Enter 2d number:");
        second = number.nextFloat();
        do {
            if (second >20){
                System.out.println("Your number should be more or equal to -20, and less or equal than 20. Please enter a correct number");
                second = number.nextFloat();
            }
            else if (second <-20) {
                System.out.println("Your number should be more or equal to -20, and less or equal than 20. Please enter a correct number");
                second = number.nextFloat();
            }
            else
                System.out.println("You selected correct second number. ");
        }
        while (second >20 || second <-20);

        while(recoursion) {
            recoursion = false;
            System.out.println("Please select math operation: +,-,*,/ ");
            action = (char) System.in.read();

            switch (action){
                case '+':
                    result = first + second;
                    System.out.println("Your result is:" + result);
                    break;
                case '-':
                    result = first - second;
                    System.out.println("Your result is:" + result);
                    break;
                case '*':
                    result = first * second;
                    System.out.println("Your result is:" + result);
                    break;
                case '/':
                    result = first / second;
                    System.out.println("Your result is:" + result);
                    break;
                default:
                    System.out.println("You selected an incorrect math operation. ");
                    recoursion = true;
                    break;
            }

            System.out.println("Would you like to continue calculation with another math operation? 1 Yes /2 No");
            further = number.nextFloat();
            if (further == 1)
                recoursion = true;
            else if (further == 2)
                recoursion = false;
            else
                System.out.println("You should be attentive");

            if (further == 2)
                System.out.println("Thank you. See you later");
        }

        Date dateOfCalculation = new Date();
        System.out.println(dateOfCalculation);

        try(FileWriter writeToFile = new FileWriter("calculation_results.txt", true))
        {
            String text = "\n Result of your calculation is:" + result + "\t" + dateOfCalculation;
            writeToFile.write(text);
            writeToFile.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

