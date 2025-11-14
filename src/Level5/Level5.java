package Level5;

import java.util.Scanner;

public class Level5 {
    public static String solve(String input) {
        Scanner scanner = new Scanner(input);

        StringBuilder output = new StringBuilder();

        int lines = scanner.nextInt();

        scanner.nextLine();

        System.out.println(lines);

        for (int i = 0; i < lines; i++) {

            String line = scanner.nextLine();
            String[] splitted = line.split(",");

            Scanner linescanneX = new Scanner(splitted[0]);
            Scanner linescanney = new Scanner(splitted[1]);
            String stringX = test(linescanneX);
            String stringY = test(linescanney);

            output.append(stringX + "\n" + stringY + "\n" + "\n");
        }

        return String.valueOf(output);
    }


    private static String test(Scanner scanner) {

        int distance = scanner.nextInt();

        int currentPace = 0;

        int maxCounter = 0;

        StringBuilder linebuilder = new StringBuilder();

        linebuilder.append("0 ");


        int iterations = (int)Math.abs(Math.ceil((double)distance / 2));

        if (distance < 0) {
            iterations = (int)Math.abs(Math.floor((double)distance / 2));
        }

        for (int j = 0; Math.abs(j) < iterations; j++) {
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

        int f = 0;

        int iterations2 = (int)Math.abs(Math.floor((double)distance / 2));

        if (distance < 0) {
            iterations2 = (int)Math.abs(Math.ceil((double)distance / 2));
        }

        for (int j = 0; j < iterations2; j++) {
            if (f == 0 && distance % 2 == 0) {
                f = 1;
            }
            else if (currentPace == 5 || currentPace == -5) {
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

        linebuilder.append("0");
        return String.valueOf(linebuilder);
           }
}