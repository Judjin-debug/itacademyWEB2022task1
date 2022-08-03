package itacademy.java.web.task8.main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
import java.io.*;

public class TaskMain {

    static String greetingText = "This program counts the sum of multiples of a given K\n" +
            "Write the K value:";


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
            System.out.print("K=");
            int num1 = scan.nextInt();
            int result = sumCalculate(num1);
            System.out.println("The sum value is " + String.valueOf(result));
        } catch (FileNotFoundException e) {
            System.err.println("File not found exception");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO exception");
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.err.println("Runtime exception");
            e.printStackTrace();
        }

    }

    static int sumCalculate(int k) throws IOException {

        Integer[] arr = arrayRead();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1)
                throw new IOException("Array elements must be positive integers");
            if (arr[i] % k == 0)
                sum += arr[i];
        };
        return sum;


    };

    static Integer[] arrayRead() throws FileNotFoundException {

        String filepath1 = "task8arrayInput.txt";

        Scanner scan1 = new Scanner(new BufferedReader(new FileReader(filepath1)));

        scan1.nextLine();
        int arrLength = scan1.nextInt();
        scan1.nextLine();
        scan1.nextLine();

        Integer[] arr = new Integer[arrLength];
        for (var i  = 0; i < arrLength; i++) {
            arr[i] = scan1.nextInt();
        }

        return arr;

    };

    static <T> void arr1DPrint(T[] array) {

        System.out.println("Printing array of size " + String.valueOf(array.length) + ":");
        for (var i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("Finished printing");

    }

}
