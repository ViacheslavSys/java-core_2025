package LR_5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input size array:");
        int size = in.nextInt();

        int[] arr = new int[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }

        System.out.println("Array:");
        System.out.println(Arrays.toString(arr));

        int[] arrResult = filteredEvenNumbers(arr);
        System.out.println("Result array:");
        System.out.println(Arrays.toString(arrResult));

        in.close();
    }

    public static int[] filteredEvenNumbers(int[] arr) {
        return Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
    }
}

