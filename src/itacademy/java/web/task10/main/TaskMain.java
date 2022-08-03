package itacademy.java.web.task10.main;

import java.util.Scanner;
import java.io.*;

public class TaskMain {

    static String greetingText = "This program creates a 2d array of size n by n\n" +
            "Write the n value:";


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
            int n = scan.nextInt();
            int[][] result = matrixCreate(n);
            arr2DPrint(result);
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

    };

    static int[][] matrixCreate(int n) throws IOException {

        if (n < 0) {
            throw new IOException("Matrix size must be a non-negative integer");
        }

        int[][] arr = new int[n][n];
        for (var i = 0; i < n; i += 2) {
            for (var j = 0; j < n; j ++) {
                arr[i][j] = j + 1;
            }
        }

        for (var i = 1; i < n; i += 2) {
            for (var j = 0; j < n; j ++) {
                arr[i][j] = n - j;
            }
        }

        return arr;

    };

    static void arr2DPrint(int[][] array) {

        int padLength = determineLengthOfIntNum(findMaxAbsIn2DIntArray(array)) + 2;

        for (var i = 0; i < array.length; i++) {
            for (int j : array[i]) {
                System.out.print(padLeft(String.valueOf(j), padLength));
            }
            System.out.println();
        }


    };

    static String padLeft (String s, int n) {

        return String.format("%" + n + "s", s);

    };

    static int findMaxAbsIn2DIntArray (int[][] array) {

        int max = Math.abs(array[0][0]);

        for (var i = 0; i < array.length; i++) {
            for (int j : array[i]) {
                if (Math.abs(j) > max)
                    max = Math.abs(j);
            }
        }

        return max;

    };

    static int determineLengthOfIntNum(int num) {

        return (int) Math.floor(Math.log10(num) + 1);

    };


}
