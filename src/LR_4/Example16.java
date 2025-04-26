package LR_4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        try {
            System.out.print("Введите номер столбца (от 0 до 2): ");
            int column = in.nextInt();

            if (column < 0 || column >= matrix[0].length) {
                throw new ArrayIndexOutOfBoundsException("Нет столбца с таким номером");
            }

            System.out.println("Столбец " + column + ":");
            for (int[] row : matrix) {
                System.out.println(row[column]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введена строка вместо числа");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка: " + e.getMessage());
        } finally {
            in.close();
        }
    }
}
