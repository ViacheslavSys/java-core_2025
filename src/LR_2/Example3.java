package LR_2;

import java.util.Scanner;

public class Example3 {
    public static String caesarCipher(String text, int key, boolean decrypt) {
        if (decrypt) {
            key = -key;
        }
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base + key + 26) % 26 + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input text to encrypt:");
        String text = in.nextLine();

        System.out.println("Input key:");
        int key = in.nextInt();
        System.out.println();

        String encryptedText = caesarCipher(text, key, false);
        System.out.println("Text after conversion: " + encryptedText);

        boolean validInput = false;
        while (!validInput){
            System.out.println("Perform the reverse transformation? (y/n):");
            String choice = in.nextLine();

            if (choice.equals("y")) {
                String decryptedText = caesarCipher(encryptedText,key,true);
                System.out.println("Text after reverse conversion: " + decryptedText);
                validInput = true;
            } else if (choice.equals("n")) {
                System.out.println("Good bye!");
                validInput = true;
            }
            else {
                System.out.println("Input the correct answer.");
            }
        }

        in.close();
    }
}
