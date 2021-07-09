package presentation.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String goodFilepath = "src/resources/test.txt";
        String falseFilepath = "kiscica";

        System.out.println("hello");

        try {
            String text = readFile(falseFilepath);
            System.out.println(text);
        } catch (RuntimeException e) {
            System.out.println("Exception occurred. Message is: " + e.getMessage());
        }

        System.out.println("program end");
    }

    public static void askForUserNumber() {
        Scanner input = new Scanner(System.in);

        System.out.println("Give me a number!");

        try {
            int userNumber = convertToNumber(input.next());
            System.out.println("Your number is " + userNumber);
        } catch (Exception e) {
            System.out.println("Oops!");
        }
    }

    public static String readFile(String filepath) throws RuntimeException {
        System.out.println("trying to read a file can be found: " + filepath);
        File file = new File(filepath);

        try {
            Scanner input = new Scanner(file);
            StringBuilder b = new StringBuilder();

            while (input.hasNextLine()) {
                b.append(input.nextLine());
                b.append("\n");
            }

            return b.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found.");
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong.");
        }
    }

    public static int convertToNumber(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new RuntimeException("NAN");
        } catch (Exception e) {
            throw new RuntimeException("something went wrong");
        }
    }

}
