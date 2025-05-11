package timus.task_2001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a1 = in.nextInt();
        int b1 = in.nextInt();
        in.nextLine();

        int a2 = in.nextInt();
        int b2 = in.nextInt();
        in.nextLine();

        int a3 = in.nextInt();
        int b3 = in.nextInt();

        int x = a1 - a3;
        int y = b1 - b2;

        System.out.println(x + " " + y);
        in.close();
    }
}
