package LR_7;

import LR_7.Example1.Person;

import java.io.*;

public class Example5 {
    public static void main(String[] args) {
        String filename = "person.ser";

        Person person = new Person("Иван", 25);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(person);
            System.out.println("Объект успешно записан в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Person restoredPerson = (Person) ois.readObject();

            System.out.println("Объект восстановлен из файла:");
            System.out.println("Имя: " + restoredPerson.getName());
            System.out.println("Возраст: " + restoredPerson.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
