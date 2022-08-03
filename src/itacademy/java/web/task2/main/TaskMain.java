package itacademy.java.web.task2.main;

import java.util.Scanner;
import java.lang.Math;


public class TaskMain {

    static String greetingText = "This program counts expression by a given formula\n" +
                                 "Write the three numbers consecutively";


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
            System.out.print("c=");
            double num3 = scan.nextFloat();
            double result = expressionCalculate(num1, num2, num3);
            System.out.println("The expression value is " + String.valueOf(result));
        } catch (RuntimeException e) {
            System.err.println("Runtime exception");
            e.printStackTrace();
        }

    }

    static double expressionCalculate(double a, double b, double c) {

        return (b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / (2 * a) + Math.pow(a, 3) * c + 1 / Math.pow(b, 2);

    }

}

