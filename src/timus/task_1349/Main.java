package timus.task_1349;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        // Если n == 0, решений нет
        if (n == 0) {
            System.out.println(-1);
            return;
        }

        // Поиск минимальных a, b, c
        for (int a = 1; a <= 100; a++) {
            for (int b = a + 1; b <= 100; b++) {  // b > a
                for (int c = b + 1; c <= 100; c++) {  // c > b
                    if (Math.pow(a, n) + Math.pow(b, n) == Math.pow(c, n)) {
                        System.out.println(a + " " + b + " " + c);
                        return;
                    }
                }
            }
        }

        // Если ничего не нашли, выводим -1
        System.out.println(-1);
    }
}
