package LR_1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input a number:");
        int inputNumber = in.nextInt();

        int previous = inputNumber - 1;
        int next = inputNumber + 1;
        int fourth = (int) Math.pow(previous + inputNumber + next, 2);

        System.out.printf("Sequence:\n%d, %d, %d, %d", previous, inputNumber, next, fourth);
        in.close();
    }
}
