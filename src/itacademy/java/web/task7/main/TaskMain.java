package itacademy.java.web.task7.main;

import java.util.Scanner;
import java.lang.Math;


public class TaskMain {

    static String greetingText = "This program counts the value of a function F(x)\n" +
            "Write the x value:";


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
            System.out.print("x=");
            double num1 = scan.nextFloat();
            double result = formulaCalculate(num1);
            System.out.println("The expression value is " + String.valueOf(result));
        } catch (RuntimeException e) {
            System.err.println("Runtime exception");
            e.printStackTrace();
        }

    }

    static double formulaCalculate(double x) {

        return Math.pow(Math.sin(x), 2) - Math.cos(2 * x);

    }

}
