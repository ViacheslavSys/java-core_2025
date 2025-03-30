package LR_3;

import java.util.HashMap;
import java.util.Map;

public class Example5 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(0, "BMW");
        map.put(1, "Ford");
        map.put(2, "Chevrolet");
        map.put(3, "Honda");
        map.put(4, "Toyota");
        map.put(5, "Mercedes");
        map.put(6, "Audi");
        map.put(7, "Volkswagen");
        map.put(8, "Nissan");
        map.put(9, "Hyundai");

        System.out.println("Марки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        if (map.containsKey(0)) {
            System.out.println("Ключ = 0, марка: " + map.get(0));
        }

        int product = 1;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
            }
        }

        System.out.println("Произведение ключей (длина марки > 5): " + product);
    }
}
