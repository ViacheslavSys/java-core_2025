package timus.task_1197;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        short n = in.nextShort();
        in.nextLine();

        while(n > 0)
        {
            String s = in.nextLine();
            char l = s.charAt(0), r = s.charAt(1);
            System.out.println(
                    (l == 'a' || l == 'h') ?
                            (r == '1' || r == '8' ? 2 : r == '2' || r == '7' ? 3 : 4) :
                            (l == 'b' || l == 'g') ?
                                    (r == '1' || r == '8' ? 3 : r == '2' || r == '7' ? 4 : 6) :
                                    (r == '1' || r == '8' ? 4 : r == '2' || r == '7' ? 6 : 8));
            n--;
        }
        in.close();
    }

}
