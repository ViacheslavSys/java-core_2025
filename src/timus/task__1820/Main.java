package timus.task__1820;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int answer;
        int n = in.nextInt();
        int k = in.nextInt();

        if (n <= k) {
            answer = 2;
        } else {
            if (n * 2 % k == 0) {
                answer = n * 2 / k;
            } else {
                answer = n * 2 / k + 1;
            }
        }

        System.out.println(answer);
        in.close();
    }
}
