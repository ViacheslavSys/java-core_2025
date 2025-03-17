package timus.task_2100;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int sum = 2;
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            sum++;
            if (name.contains("+one")) {
                sum++;
            }
        }
        if (sum == 13) {
            System.out.println(1400);
        } else {
            System.out.println(sum * 100);
        }
        in.close();
    }
}
