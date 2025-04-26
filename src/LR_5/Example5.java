package LR_5;

import java.util.List;
import java.util.stream.Collectors;

public class Example5 {
    public static void main(String[] args) {
        String string = "6.\tНапишите функцию, которая принимает на вход список строк " +
                "и возвращает новый список, содержащий только те строки, которые содержат " +
                "заданную подстроку.";

        List<String> strings = List.of(string.split(" "));

        System.out.println("\n" + "Строка после сплитования:" + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        String substring = "воз";

        List<String> resultString = filterStrings(strings, substring);
        System.out.println("\n" + "Result" + "\n");
        for (String e : resultString) {
            System.out.println(e);
        }
    }

    public static List<String> filterStrings(List<String> list, String substring) {
        return list.stream().
                filter(str -> str.toLowerCase().contains(substring.toLowerCase()))
                .collect(Collectors.toList());
    }
}
