package timus.task_1409;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int harryCanCount = in.nextInt();
        int larryCanCount = in.nextInt();

        int totalCanCount = harryCanCount + larryCanCount - 1;

        int larryUnhitCanCount = totalCanCount - larryCanCount;
        int harryUnhitCanCount = totalCanCount - harryCanCount;

        System.out.println(harryUnhitCanCount + " " + larryUnhitCanCount);
        in.close();
    }
}
