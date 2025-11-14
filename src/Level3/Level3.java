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

            Scanner linescanner = new Scanner(line);

            int distance = linescanner.nextInt();

            int currentPace = 0;

            int maxCounter = 0;

            StringBuilder linebuilder = new StringBuilder();

            linebuilder.append("0 ");

            for (int j = 0; Math.abs(j) < Math.abs(Math.floor((double)distance / 2)); j++) {
                if (currentPace == 0) {
                    if (distance > 0) {
                        currentPace = 5;
                    } else {
                        currentPace = -5;
                    }
                }
                else if (currentPace == 1 || currentPace == -1) {
                    maxCounter++;
                }
                else if (currentPace < 0) {
                    currentPace++;
                } else {
                    currentPace--;
                }

                linebuilder.append(currentPace);
                linebuilder.append(" ");
            }

            for (int j = 0; j < Math.abs(Math.floor((double)distance / 2)); j++) {
                if (currentPace == 5 || currentPace == -5) {
                    currentPace = 0;
                }
                else if (currentPace == 1 || currentPace == -1) {
                    if (maxCounter > 0) {
                        maxCounter--;
                    } else {
                        if (currentPace < 0) {
                            currentPace--;
                        } else {
                            currentPace++;
                        }
                    }
                } else {
                    if (currentPace < 0) {
                        currentPace--;
                    } else {
                        currentPace++;
                    }
                }

                linebuilder.append(currentPace);
                linebuilder.append(" ");
            }


            //linebuilder.append(new StringBuilder(linebuilder).reverse());

            output.append(linebuilder);

            if (i != lines-1) {
                output.append("\n");
            }

        }

        return String.valueOf(output);
    }
}
