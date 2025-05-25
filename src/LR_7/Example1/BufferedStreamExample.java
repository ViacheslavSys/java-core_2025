package LR_7.Example1;

import java.io.*;
import java.util.Scanner;

public class BufferedStreamExample {
    public static void main(String[] args) {
        String fileName = "src/LR_7/Example1/CharStreamExample.txt";
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
            System.out.println("Данные записаны в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи  в файл: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            char[] buffer = new char[1024];
            int charRead = reader.read(buffer);
            String readData = new String(buffer, 0, charRead);
            System.out.println("Прочитанные данные: " + readData);
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        if (new File(fileName).delete()) {
            System.out.println("Файл удален: " + fileName);
        } else {
            System.out.println("н удалось найти файл: " + fileName);
        }
        in.close();
    }
}
