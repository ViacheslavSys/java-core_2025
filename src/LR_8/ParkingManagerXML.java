package LR_8;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class ParkingManagerXML {

    private static final String FILE_NAME = "src/LR_8/parking.xml";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        createFileIfNotExists();

        while (true) {
            System.out.println("\n--- Меню ---");
            System.out.println("1. Добавить автомобиль");
            System.out.println("2. Поиск автомобиля");
            System.out.println("3. Удалить автомобиль");
            System.out.println("4. Выход");
            System.out.print("Выберите действие: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Марка: ");
                    String brand = scanner.nextLine();
                    System.out.print("Модель: ");
                    String model = scanner.nextLine();
                    System.out.print("Год: ");
                    String year = scanner.nextLine();
                    System.out.print("Гос. номер: ");
                    String license = scanner.nextLine();
                    addAutomobile(brand, model, year, license);
                }
                case "2" -> {
                    System.out.print("Введите марку (или оставьте пустым): ");
                    String brand = scanner.nextLine();
                    System.out.print("Введите год (или оставьте пустым): ");
                    String year = scanner.nextLine();
                    searchAutomobile(brand, year);
                }
                case "3" -> {
                    System.out.print("Введите номер автомобиля для удаления: ");
                    String license = scanner.nextLine();
                    deleteAutomobile(license);
                }
                case "4" -> {
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
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("parking");
            doc.appendChild(root);
            saveDocument(doc);
        }
    }

    private static void addAutomobile(String brand, String model, String year, String license) throws Exception {
        Document doc = loadDocument();

        Element automobile = doc.createElement("automobile");

        appendElement(doc, automobile, "brand", brand);
        appendElement(doc, automobile, "model", model);
        appendElement(doc, automobile, "year", year);
        appendElement(doc, automobile, "license", license);

        doc.getDocumentElement().appendChild(automobile);
        saveDocument(doc);
        System.out.println("Автомобиль добавлен.");
    }

    private static void searchAutomobile(String brandFilter, String yearFilter) throws Exception {
        Document doc = loadDocument();
        NodeList nodeList = doc.getElementsByTagName("automobile");
        boolean found = false;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element auto = (Element) nodeList.item(i);
            String brand = auto.getElementsByTagName("brand").item(0).getTextContent();
            String year = auto.getElementsByTagName("year").item(0).getTextContent();

            boolean brandMatches = brandFilter.isEmpty() || brand.equalsIgnoreCase(brandFilter);
            boolean yearMatches = yearFilter.isEmpty() || year.equals(yearFilter);

            if (brandMatches && yearMatches) {
                String model = auto.getElementsByTagName("model").item(0).getTextContent();
                String license = auto.getElementsByTagName("license").item(0).getTextContent();
                System.out.printf("Марка: %s, Модель: %s, Год: %s, Номер: %s%n", brand, model, year, license);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Автомобили не найдены.");
        }
    }

    private static void deleteAutomobile(String licenseToDelete) throws Exception {
        Document doc = loadDocument();
        NodeList nodeList = doc.getElementsByTagName("automobile");
        boolean deleted = false;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element auto = (Element) nodeList.item(i);
            String license = auto.getElementsByTagName("license").item(0).getTextContent();

            if (license.equalsIgnoreCase(licenseToDelete)) {
                auto.getParentNode().removeChild(auto);
                saveDocument(doc);
                System.out.println("Автомобиль удалён.");
                deleted = true;
                break;
            }
        }

        if (!deleted) {
            System.out.println("Автомобиль не найден.");
        }
    }

    private static Document loadDocument() throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return builder.parse(new File(FILE_NAME));
    }

    private static void saveDocument(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(new File(FILE_NAME)));
    }

    private static void appendElement(Document doc, Element parent, String tag, String value) {
        Element elem = doc.createElement(tag);
        elem.setTextContent(value);
        parent.appendChild(elem);
    }
}
