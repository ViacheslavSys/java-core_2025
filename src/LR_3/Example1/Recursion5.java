package LR_3.Example1;

public class Recursion5 {
    public static void main(String[] args) {
        System.out.println("Result: " + fact(5));
    }

    public static int fact(int n) {
        System.out.println("fact(" + n + ")");
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fact(n - 2) + fact(n - 1);
        }
    }
}
