package timus.task_1607;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        in.close();

        while (a < c) {
            a = Math.min(a+b,c);

            c = Math.max(a, c-d);
        }
        System.out.println(a);
    }
}

