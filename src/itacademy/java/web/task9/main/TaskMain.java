package itacademy.java.web.task9.main;

import java.util.Scanner;
import java.io.*;

public class TaskMain {

    static String greetingText = "This program merges two arrays, putting the second one inside the first one" +
            " on the position k\n" +
            "Write the k value:";


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
            int k = scan.nextInt();
            Integer[] arr1 = arrayRead("task9array1Input.txt");
            Integer[] arr2 = arrayRead("task9array2Input.txt");
            Integer[] result = arrayMerge(arr1, arr2, k);
            arr1DPrint(result);
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

    static Integer[] arrayMerge(Integer[] arr1, Integer[] arr2, int k) throws IOException {

        if (k > arr1.length || k < 0) {
            throw new IOException("Illegal position to insert in");
        }

        Integer[] result = new Integer[arr1.length + arr2.length];
        for (var i = 0; i < k; i++) {
            result[i] = arr1[i];
        };
        for (var i = 0; i < arr2.length; i++) {
            result[k + i] = arr2[i];
        };
        for (var i = k; i < arr1.length; i++) {
            result[arr2.length + i] = arr1[i];
        };

        return result;

    };

    static Integer[] arrayRead(String filepath) throws FileNotFoundException {


        Scanner scan = new Scanner(new BufferedReader(new FileReader(filepath)));

        scan.nextLine();
        int arrLength = scan.nextInt();
        scan.nextLine();
        scan.nextLine();

        Integer[] arr = new Integer[arrLength];
        for (var i  = 0; i < arrLength; i++) {
            arr[i] = scan.nextInt();
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
