package LR_1;

import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input name of the month:");
        String nameMonth = in.nextLine();

        System.out.println("Input the number of days in this month:");
        int numberDay = in.nextInt();

        Integer actualDays = getDaysInMonth(nameMonth);
        if (numberDay <= 0) {
            System.out.println("Error: The number of days in a month cannot be less than or equal to 0.");
        } else {
            if (actualDays == null) {
                System.out.println("Error: Incorrect name of month.");
            } else if (numberDay <= actualDays) {
                System.out.printf("Month of %s contains %d days!", nameMonth, numberDay);
            } else {
                System.out.printf("Month of %s does not contains %d days!", nameMonth, numberDay);
            }
        }
        in.close();
    }

    //Метод, который возвращает количество дней в каждом месяце:
    private static Integer getDaysInMonth(String month) {
        return switch (month.toLowerCase()) {
            case "january", "march", "may", "july", "august", "october", "december" -> 31;
            case "april", "june", "september", "november" -> 30;
            case "february" -> 28; // Среднее значение без високосных лет
            default -> null;
        };
    }
}
