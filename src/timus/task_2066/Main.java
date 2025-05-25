package timus.task_2066;

import java.util.*;

public class Main {
    static int eval(int x, char op1, int y, char op2, int z) {
        if (op1 == '*') {
            return calc(x * y, op2, z);
        } else if (op2 == '*') {
            return calc(x, op1, y * z);
        } else {
            return calc(x, op1, calc(y, op2, z));
        }
    }

    static int calc(int a, char op, int b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[3];
        nums[0] = scanner.nextInt();
        nums[1] = scanner.nextInt();
        nums[2] = scanner.nextInt();

        char[] ops = {'+', '-', '*'};
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == i) continue;
                for (int k = 0; k < 3; k++) {
                    if (k == i || k == j) continue;
                    int x = nums[i];
                    int y = nums[j];
                    int z = nums[k];

                    for (char op1 : ops) {
                        for (char op2 : ops) {
                            int result = eval(x, op1, y, op2, z);
                            min = Math.min(min, result);
                        }
                    }
                }
            }
        }

        System.out.println(min);
    }
}
