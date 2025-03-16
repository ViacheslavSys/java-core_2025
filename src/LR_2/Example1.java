package LR_2;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Input size array:");
        int sizeArr = in.nextInt();
        int[] array = new int[sizeArr];

        for (int i = 0; i < sizeArr; i++) {
            array[i] = random.nextInt();
        }

        int minValue = array[0];

        System.out.println("Array:");
        for (int num : array) {
            System.out.println(num + " ");
            if(num < minValue){
                minValue = num;
            }
        }
        System.out.println("Min value: " + minValue);

        System.out.println("Indexes: ");
        for(int i = 0; i < sizeArr; i++){
            if(array[i] == minValue){
                System.out.println(i);
            }
        }

        in.close();
    }
}
