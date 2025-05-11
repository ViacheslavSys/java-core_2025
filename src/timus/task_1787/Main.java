package timus.task_1787;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int n = in.nextInt();
        int[] arrivals = new int[n];
        for (int i = 0; i < n; i++) {
            arrivals[i] = in.nextInt();
        }

        int carsInQueue = 0;
        for (int i = 0; i < n; i++) {
            carsInQueue += arrivals[i];
            int turnedCars = Math.min(k, carsInQueue);
            carsInQueue -= turnedCars;
        }

        System.out.println(carsInQueue);
        in.close();
    }
}
