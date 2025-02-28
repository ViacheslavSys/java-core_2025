package LR_1;

import java.time.LocalDate;
import java.util.Scanner;

public class Example11 {
    public static void main(String[] args) {
        int currentYear = LocalDate.now().getYear();

        Scanner in = new Scanner(System.in);

        System.out.println("Input name and year of birth (separated by a space):");
        String name = in.next();
        int yearBirth = in.nextInt();

        int age = currentYear - yearBirth;

        System.out.printf("Hello, %s! If you forgot how old you are, then this year you %d.", name, age);
        in.close();
    }
}
