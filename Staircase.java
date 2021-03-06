package hms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Staircase {

    // Complete the staircase function below.
    static void staircase(int n) {
        for(int i=n;i<0 ;i--) {
            for(int j = 1;j<=n;j++) {
                if(i == j || j > i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }  
            System.out.println();
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println("..........");
        staircase(2);

        scanner.close();
    }
}
