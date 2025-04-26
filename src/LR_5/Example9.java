package LR_5;

import java.util.List;
import java.util.stream.Collectors;

public class Example9 {
    public static void main(String[] args) {
        String string = "10.\tНапишите функцию, " +
                "которая принимает на вход список строк и " +
                "возвращает новый список, содержащий только те строки, " +
                "которые содержат только буквы (без цифр и символов).";

        List<String> strings = List.of(string.split(" "));

        System.out.println("\n" + "Строка после сплитования:" + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> resultString = filterStringsWithoutSymbols(strings);

        System.out.println("\n" + "Result" + "\n");
        for (String e : resultString) {
            System.out.println(e);
        }


    }

    public static List<String> filterStringsWithoutSymbols(List<String> list) {
        return list.stream().
                filter(str -> str.matches("[a-zA-Zа-яА-Я]+"))
                .collect(Collectors.toList());
    }

}
