package LR_3;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input size array:");
        int size = in.nextInt();
        int[] arr = new int[size];

        System.out.println("Input numbers:");
        inputArray(in, arr, 0);

        System.out.println("Array:");
        outputArray(arr, 0);

        in.close();
    }

    public static void inputArray(Scanner in, int[] array, int index) {
        if (index < array.length) {
            array[index] = in.nextInt();
            inputArray(in, array, index + 1);
        }
    }

    public static void outputArray(int[] array, int index) {
        if (index < array.length) {
            System.out.print(array[index] + " ");
            outputArray(array, index + 1);
        }
    }
}
