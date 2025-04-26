package LR_4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example15 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Введите размер массива: ");
            int size = in.nextInt();
            int[] array = new int[size];

            System.out.println("Введите элементы массива:");
            for (int i = 0; i < size; i++) {
                System.out.print("Элемент " + (i + 1) + ": ");
                array[i] = in.nextInt();
            }

            int sum = 0;
            int count = 0;
            for (int num : array) {
                if (num > 0) {
                    sum += num;
                    count++;
                }
            }

            if (count == 0) {
                throw new IllegalArgumentException("Положительные элементы отсутствуют");
            }

            double average = (double) sum / count;
            System.out.println("Среднее значение положительных элементов: " + average);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введена строка вместо числа или несоответствие числового типа данных");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка: " + e.getMessage());
        } finally {
            in.close();
        }
    }
}

