package itacademy.java.web.task3.main;

import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;


public class TaskMain {

    static String greetingText = "This program calculates perimeter and square of a right triangle " +
                                 "by the given orthogonal sides\n" +
                                 "Write the two sides' lengths consecutively:";


    public static void main (String... args) {

        looper();

    }


    static void looper() {

        String msg = "Continue? [y/N]";

        Scanner scan = new Scanner(System.in);
        boolean stopFlag = false;
        do {
            boneRunner(greetingText);
            System.out.println(msg);
            String userInput = scan.next();
            if(!"y".equals(userInput.toLowerCase()) && !"yes".equals(userInput.toLowerCase()))
                stopFlag = true;
        } while (!stopFlag);
        scan.close();
    }

    static void boneRunner(String greetingText) {

        Scanner scan = new Scanner(System.in);
        System.out.println(greetingText);
        try {
            System.out.print("a=");
            double num1 = scan.nextFloat();
            System.out.print("b=");
            double num2 = scan.nextFloat();
            double square = squareCalculate(num1, num2);
            double perimeter = perimeterCalculate(num1, num2);
            System.out.println("The square is " + String.valueOf(square));
            System.out.println("The perimeter is " + String.valueOf(perimeter));
        } catch (RuntimeException e) {
            System.out.println("Runtime exception");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static double perimeterCalculate(double a, double b) throws IOException {

        if (a < 0 || b < 0) {
            System.out.println("IO exception");
            throw new IOException("Triangle sides can't be negative");
        }
        return a + b + Math.sqrt(a * a + b * b);

    }

    static double squareCalculate(double a, double b) throws IOException {

        if (a < 0 || b < 0) {
            System.out.println("IO exception in squareCalculate method");
            throw new IOException("Triangle sides can't be negative");
        }

        return 0.5 * (a * b);

    }

}