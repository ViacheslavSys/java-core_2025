package LR_1;

import java.util.Scanner;

public class Example15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input the first number:");
        int first = in.nextInt();

        System.out.println("Input the second number:");
        int second = in.nextInt();

        int sum = first + second;
        int difference = first - second;

        System.out.printf("Sum: %d\nDifference: %d\n", sum, difference);
        in.close();
    }
}
