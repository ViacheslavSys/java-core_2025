package LR_7.Example1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample {
    public static void main(String[] args) {
        Person person = new Person("Petr Petrov", 20);

        try {
            FileOutputStream fileOut = new FileOutputStream("src/LR_7/Example1/person.json");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            System.out.println("Serialized data is saved in person.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


