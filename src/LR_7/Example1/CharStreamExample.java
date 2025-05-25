package LR_7.Example1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamExample {
    public static void main(String[] args) {
        String fileName = "src/LR_7/Example1/CharStreamExample.txt";
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        try(FileWriter writer = new FileWriter(fileName)){
            writer.write(data);
            System.out.println("Данные записаны в файл: " + fileName);
        }
        catch (IOException e){
            System.out.println("Ошибка при записи в файл: " + e);
        }

        try (FileReader reader = new FileReader(fileName)){
            char [] buffer = new char[1024];
            int charRead = reader.read(buffer);
            String readData = new String(buffer, 0, charRead);
            System.out.println("Прочитанные данные: " + readData);
        }
        catch (IOException e){
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
