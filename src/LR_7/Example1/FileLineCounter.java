package LR_7.Example1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLineCounter {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/LR_7/Example1/input.txt"));
            int lineCount = 0;
            while (reader.readLine() != null) {
                lineCount++;
            }
            reader.close();
            System.out.println("Количество строк в файле: " + lineCount);
        } catch (IOException e) {
            System.out.println("Ошибка при подсчете строк в файле: " + e.getMessage());
        }
    }

}
