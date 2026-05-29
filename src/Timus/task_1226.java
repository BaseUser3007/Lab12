package Timus;

import java.util.Scanner;

public class task_1226 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            StringBuilder result = new StringBuilder();
            StringBuilder word = new StringBuilder();

            for (char ch : line.toCharArray()) {
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                    word.append(ch);
                } else {
                    result.append(word.reverse()).append(ch);
                    word.setLength(0); // Очищаем буфер слова
                }
            }
            result.append(word.reverse());

            System.out.println(result);
        }
    }
}
