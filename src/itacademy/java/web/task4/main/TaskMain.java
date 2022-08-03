package itacademy.java.web.task4.main;

import java.util.Scanner;


public class TaskMain {

    static String greetingText = "This program checks whether a point supplied by the given coordinates " +
                                 "belongs to a set of pre-defined 2-dimensional closed intervals\n" +
                                 "Input the coordinates:";


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
            System.out.print("y=");
            double num2 = scan.nextFloat();
            System.out.println(String.valueOf(checkBelonging(num1, num2)));
        } catch (RuntimeException e) {
            System.err.println("Runtime exception");
            e.printStackTrace();
        }

    }

    static boolean checkBelonging(double x, double y) {

        return ((Math.abs(x) <= 4 && y >= -3 && y <= 0) || (Math.abs(x) <= 2 && y >= 0 && y <= 4));

    }

}