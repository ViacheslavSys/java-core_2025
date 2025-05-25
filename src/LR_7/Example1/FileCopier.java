package LR_7.Example1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopier {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("src/LR_7/Example1/input.txt");
            FileWriter writer = new FileWriter("src/LR_7/Example1/output.txt");

            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
            reader.close();
            writer.close();
            System.out.println("Файл скопирован успешно!");
        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }

}
