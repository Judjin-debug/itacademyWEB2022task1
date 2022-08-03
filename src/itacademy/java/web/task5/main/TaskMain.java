package itacademy.java.web.task5.main;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;


public class TaskMain {

    static String greetingText = "This program maps numbers to second power if they're non-negative " +
            "or to 4-th power otherwise\n" +
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
            double[] arr = new double[3];
            System.out.print("a=");
            arr[0] = scan.nextFloat();
            System.out.print("b=");
            arr[1] = scan.nextFloat();
            System.out.print("c=");
            arr[2] = scan.nextFloat();
            arr = Arrays.stream(arr).map(x -> mapFunction(x)).toArray();
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        } catch (RuntimeException e) {
            System.err.println("Runtime exception");
            e.printStackTrace();
        }

    }

    static double mapFunction(double num) {
        if (num >= 0) {
            num = Math.pow(num, 2);
        } else {
            num = Math.pow(num, 4);
        }
        return num;

    }

}
