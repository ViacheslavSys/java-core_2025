package LR_1;

import java.util.Scanner;

public class Example13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input a:");
        int a = in.nextInt();

        System.out.println("Input b:");
        int b = in.nextInt();

        System.out.printf("a + b = %d", a+b);
        in.close();
    }
}
