package timus.task_1785;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string;

        int n = in.nextInt();
        if (n > 999) {
            string = "legion";
        } else if (n > 499) {
            string = "zounds";
        } else if (n > 249) {
            string = "swarm";
        } else if (n > 99) {
            string = "throng";
        } else if (n > 49) {
            string = "horde";
        } else if (n > 19) {
            string = "lots";
        } else if (n > 9) {
            string = "pack";
        } else if (n > 4) {
            string = "several";
        } else {
            string = "few";
        }
        System.out.println(string);
        in.close();
    }
}
