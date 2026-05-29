package Timus;

import java.util.Scanner;

public class task_1197 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        while (n-- > 0) {
            String s = in.next();
            int x = Math.min(s.charAt(0) - 'a', 'h' - s.charAt(0));
            int y = Math.min(s.charAt(1) - '1', '8' - s.charAt(1));

            // Матрица ответов
            int[][] answers = {
                    {2, 3, 4, 4},
                    {3, 4, 6, 6},
                    {4, 6, 8, 8},
                    {4, 6, 8, 8}
            };

            System.out.println(answers[x][y]);
        }
    }
}
