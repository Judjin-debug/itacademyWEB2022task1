package itacademy.java.web.task6.main;

import java.util.Arrays;
import java.util.Scanner;


public class TaskMain {

    static String greetingText = "This program counts the sum of the smallest and the largest number\n" +
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

        double[] arr = {a, b, c};
        arr = Arrays.stream(arr).sorted().toArray();
        return arr[0] + arr[2];

    }

}


