package LR_2;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input rows:");
        int rows = in.nextInt();

        System.out.println("Input columns:");
        int columns = in.nextInt();

        int[][] array = new int[rows][columns];
        int value = 1;

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < columns; j++) {
                    array[i][j] = value++;
                }
            } else {
                for (int j = columns - 1; j >= 0; j--) {
                    array[i][j] = value++;
                }
            }
        }

        System.out.println("Array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        in.close();
    }
}
