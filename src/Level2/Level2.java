package Level2;

import java.util.Scanner;

public class Level2 {
    public static String solve(String input) {
        Scanner scanner = new Scanner(input);

        StringBuilder output = new StringBuilder();

        int lines = scanner.nextInt();

        scanner.nextLine();


        for (int i = 0; i < lines; i++) {

            String line = scanner.nextLine();

            Scanner scannerline = new Scanner((line));

            int time = 0;
            int space = 0;
            while(scannerline.hasNextInt()) {
                int value = scannerline.nextInt();
                if (value == 0) {
                    time++;
                } else if (value > 0) {
                    space++;
                    time += value;
                } else {
                    space--;
                    time -= value;
                }
            }
            output.append(space);
            output.append(" ");
            output.append(time);

            if (i != lines-1) {
                output.append("\n");
            }

        }

        return String.valueOf(output);
    }
}
