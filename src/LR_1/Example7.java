package LR_1;

import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input name and age (separated by a space):");
        String name = in.next();
        int age = in.nextInt();

        System.out.printf("Your name: %s\nYour age: %d\n", name, age);
        in.close();
    }
}
