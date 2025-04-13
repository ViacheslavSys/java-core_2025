package LR4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Введите размер массива: ");
            int size = in.nextInt();
            byte[] array = new byte[size];

            System.out.println("Введите элементы массива (тип byte):");
            for (int i = 0; i < size; i++) {
                System.out.print("Элемент " + (i + 1) + ": ");
                int value = in.nextInt();

                if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Введенное значение выходит за границы диапазона byte");
                }
                array[i] = (byte) value;
            }

            byte sum = 0;
            for (byte num : array) {
                if ((sum + num) < Byte.MIN_VALUE || (sum + num) > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Сумма элементов выходит за границы диапазона byte");
                }
                sum += num;
            }

            System.out.println("Сумма элементов: " + sum);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введена строка вместо числа");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка: " + e.getMessage());
        } finally {
            in.close();
        }
    }
}
