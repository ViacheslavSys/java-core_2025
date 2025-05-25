package LR_7;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите имя файла для записи: ");
        String fileName = in.nextLine();

        System.out.print("Введите текст, который хотите записать в файл: ");
        String textToWrite = in.nextLine();

        File file = new File("src/LR_7/Example1/" + fileName);

        try (PrintWriter printWriter = new PrintWriter(file, "UTF-8")) {
            printWriter.println(textToWrite);
            System.out.println("Данные записаны в файл: " + file);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }

        in.close();

    }
}
