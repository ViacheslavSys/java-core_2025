package LR_3;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input number: ");
        int num = in.nextInt();

        System.out.println();

        System.out.println("Binary:" );
        convertToBinary(num);

        in.close();
    }
    public static void convertToBinary(int n) {
        if (n > 1) {
            convertToBinary(n / 2);
        }
        System.out.print(n % 2);
    }
}
