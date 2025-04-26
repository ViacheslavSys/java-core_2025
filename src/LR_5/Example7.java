package LR_5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String string = "Напишите функцию, которая принимает на вход список строк " +
                "и возвращает новый список, содержащий только те строки, которые имеют длину " +
                "больше заданного значения";

        List<String> strings = List.of(string.split(" "));

        System.out.println("\n" + "Строка после сплитования:" + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        System.out.println("Input min length:");
        int minLength = in.nextInt();

        List<String> resultString = filterStringsByLength(strings, minLength);

        System.out.println("\n" + "Result" + "\n");
        for (String e : resultString) {
            System.out.println(e);
        }

        in.close();
    }

    public static List<String> filterStringsByLength(List<String> list, int minLength) {
        return list.stream().
                filter(str -> str.length() > minLength)
                .collect(Collectors.toList());
    }
}
