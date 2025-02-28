package timus.task_1877;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int lock1 = Integer.parseInt(in.nextLine());
        int lock2 = Integer.parseInt(in.nextLine());

        if ((lock1 % 2 == 0 || lock2 % 2 == 1) || (lock1 == lock2)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        in.close();
    }
}
