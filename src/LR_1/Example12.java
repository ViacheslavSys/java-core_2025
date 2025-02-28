package LR_1;

import java.time.LocalDate;
import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        int currentYear = LocalDate.now().getYear();

        Scanner in = new Scanner(System.in);

        System.out.println("Input your age:");
        int age = in.nextInt();

        int yearBirth = currentYear - age;

        System.out.printf("Dear friend, \nIf you have forgotten the year you were born, let me remind you in %d.", yearBirth);
        in.close();
    }
}
