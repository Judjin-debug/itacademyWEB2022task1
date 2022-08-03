package itacademy.java.web.task1.main;

import java.io.IOException;
import java.util.Scanner;


public class TaskMain {

    static String greetingText = "This program tests whether the sum of a first and last digit of a 4-digit number " +
                                 "is equal to the sum of a second and a third digit\n" +
                                 "Input a 4-digit number to test:";

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
            Integer num = scan.nextInt();
            if (checkStatement(num)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        } catch (RuntimeException e) {
            System.err.println("Runtime exception");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static boolean checkStatement(Integer num) throws IOException {

        if ((num < 1000) || (num > 9999)) {
            System.err.println("IO exception");
            throw new IOException("Illegal number");
        }

        return ((num % 10) + (num / 1000)) == ((num / 10 % 10) + (num / 100 % 10));

    }

}
