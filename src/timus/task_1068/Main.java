package timus.task_1068;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.close();
        int sum;
        if (N > 0) {
            sum = N * (N + 1) / 2;
        } else {
            sum = (-N - 1) * (N - 2) / 2;
        }
        System.out.println(sum);
    }
}
