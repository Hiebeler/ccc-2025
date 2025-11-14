package Level3;

import java.util.Scanner;

public class Level3 {
    public static String solve(String input) {
        Scanner scanner = new Scanner(input);

        StringBuilder output = new StringBuilder();

        int lines = scanner.nextInt();

        scanner.nextLine();

        System.out.println(lines);

        for (int i = 0; i < lines; i++) {

            String line = scanner.nextLine();

            Scanner scannerline = new Scanner((line));

            int numb = 0;

            while(scannerline.hasNextInt()) {
                numb += scannerline.nextInt();
            }

            output.append(numb);

            if (i != lines-1) {
                output.append("\n");
            }

        }

        return String.valueOf(output);
    }
}
