package LR_1;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input current day of the week:");
        String weekDay = in.nextLine();

        System.out.println("Input month:");
        String month = in.nextLine();

        System.out.println("Input number day:");
        int numberDay = in.nextInt();

        System.out.printf("Today's date: %s, %d, %s", weekDay, numberDay, month);
        in.close();
    }
}
