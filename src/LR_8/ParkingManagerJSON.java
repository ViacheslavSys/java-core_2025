package LR_8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class ParkingManagerJSON {
    private static final String FILE_NAME = "src/LR_8/parking.json";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        createFileIfNotExists();

        while (true) {
            System.out.println("\n--- Меню ---");
            System.out.println("1. Добавить автомобиль");
            System.out.println("2. Поиск по марке");
            System.out.println("3. Удалить по номеру");
            System.out.println("4. Показать все");
            System.out.println("5. Выход");
            System.out.print("Выберите действие: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Марка: ");
                    String brand = scanner.nextLine();
                    System.out.print("Модель: ");
                    String model = scanner.nextLine();
                    System.out.print("Год: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.print("Гос. номер: ");
                    String license = scanner.nextLine();
                    addAutomobile(brand, model, year, license);
                }
                case "2" -> {
                    System.out.print("Введите марку: ");
                    String brand = scanner.nextLine();
                    searchByBrand(brand);
                }
                case "3" -> {
                    System.out.print("Введите номер для удаления: ");
                    String license = scanner.nextLine();
                    deleteByLicense(license);
                }
                case "4" -> showAll();
                case "5" -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Неверный ввод.");
            }
        }
    }

    private static void createFileIfNotExists() throws Exception {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            JSONObject root = new JSONObject();
            root.put("automobiles", new JSONArray());
            try (FileWriter writer = new FileWriter(FILE_NAME)) {
                writer.write(root.toJSONString());
            }
        }
    }

    private static JSONObject loadJson() throws Exception {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(new FileReader(FILE_NAME));
    }

    private static void saveJson(JSONObject root) throws Exception {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write(root.toJSONString());
        }
    }

    private static void addAutomobile(String brand, String model, int year, String license) throws Exception {
        JSONObject root = loadJson();
        JSONArray autos = (JSONArray) root.get("automobiles");

        JSONObject auto = new JSONObject();
        auto.put("brand", brand);
        auto.put("model", model);
        auto.put("year", year);
        auto.put("license", license);

        autos.add(auto);
        saveJson(root);
        System.out.println("Автомобиль добавлен.");
    }

    private static void searchByBrand(String brand) throws Exception {
        JSONObject root = loadJson();
        JSONArray autos = (JSONArray) root.get("automobiles");
        boolean found = false;

        for (Object obj : autos) {
            JSONObject auto = (JSONObject) obj;
            if (brand.equalsIgnoreCase((String) auto.get("brand"))) {
                System.out.printf("Марка: %s, Модель: %s, Год: %s, Номер: %s%n",
                        auto.get("brand"), auto.get("model"), auto.get("year"), auto.get("license"));
                found = true;
            }
        }

        if (!found) {
            System.out.println("Ничего не найдено.");
        }
    }

    private static void deleteByLicense(String license) throws Exception {
        JSONObject root = loadJson();
        JSONArray autos = (JSONArray) root.get("automobiles");
        Iterator<?> iterator = autos.iterator();
        boolean deleted = false;

        while (iterator.hasNext()) {
            JSONObject auto = (JSONObject) iterator.next();
            if (license.equalsIgnoreCase((String) auto.get("license"))) {
                iterator.remove();
                deleted = true;
            }
        }

        if (deleted) {
            saveJson(root);
            System.out.println("Автомобиль удалён.");
        } else {
            System.out.println("Автомобиль не найден.");
        }
    }

    private static void showAll() throws Exception {
        JSONObject root = loadJson();
        JSONArray autos = (JSONArray) root.get("automobiles");

        if (autos.isEmpty()) {
            System.out.println("Парковка пуста.");
        } else {
            for (Object obj : autos) {
                JSONObject auto = (JSONObject) obj;
                System.out.printf("Марка: %s, Модель: %s, Год: %s, Номер: %s%n",
                        auto.get("brand"), auto.get("model"), auto.get("year"), auto.get("license"));
            }
        }
    }
}
