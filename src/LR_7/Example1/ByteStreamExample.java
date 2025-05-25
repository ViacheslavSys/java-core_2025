package LR_7.Example1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteStreamExample {
    public static void main(String[] args) {
        String fileName = "src/LR_7/Example1/ByteStreamExample.txt";
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.write(data.getBytes());
            System.out.println("Данные записаны в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        try (FileInputStream fileInputStream = new FileInputStream(fileName)){
            byte[] buffer = new byte[1024];
            int bytesRead = fileInputStream.read(buffer);
            String readData = new String(buffer, 0, bytesRead);
            System.out.println("Прочитанные данные: " + readData);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        if(new File(fileName).delete()){
            System.out.println("Файл удален:" + fileName);
        } else {
            System.out.println("Не удалось удалить файл: " + fileName);
        }
        in.close();
    }
}
