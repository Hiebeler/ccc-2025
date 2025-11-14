package Level5;

import java.util.Scanner;

class Path {
    public String primary;
    public String secondary;

    public Path(String primary, String secondary) {
        this.primary = primary;
        this.secondary = secondary;
    }
}

public class Level5 {
    public static String solve(String input) {
        Scanner scanner = new Scanner(input);

        StringBuilder output = new StringBuilder();

        int lines = scanner.nextInt();

        scanner.nextLine();

        System.out.println(lines);

        for (int i = 0; i < lines; i++) {
            int x = 0;
            int y = 0;
            String stationLine = scanner.nextLine();
            String astroidLine = scanner.nextLine();
            String[] splittedStation = stationLine.split(",");
            String[] splittedAstroid = astroidLine.split(",");


            int stationX = new Scanner(splittedStation[0]).nextInt();
            int stationY = new Scanner(splittedStation[1]).nextInt();
            int astroidX = new Scanner(splittedAstroid[0]).nextInt();
            int astroidY = new Scanner(splittedAstroid[1]).nextInt();
            String result = iteration("", "", x, y, stationX, stationY, astroidX, astroidY);
            output.append(result);
            output.append("\n");
            output.append("\n");
        }

        return String.valueOf(output);
    }

    private static String iteration(String pathX, String pathY, int x, int y, int stationX, int stationY, int astroidX, int astroidY) {
        if (x == stationX && y == stationY) {
            return pathX.substring(0, pathX.length() - 1)  + "\n" + pathY.substring(0, pathY.length() - 1);
        }
        int diffX = Math.abs(stationX - x);
        int diffY = Math.abs(stationY - y);
        StringBuilder outputX = new StringBuilder(pathX);
        StringBuilder outputY = new StringBuilder(pathY);
        if (diffX > diffY) {
            int direction = x < stationX ? 1 : -1;
            boolean collision = isAstroidInTheWayX(x, y, stationX, astroidX, astroidY);
            if (collision) {
                //check which is better, y from station
                Path path = drive(5);
                outputY.append(path.primary);
                outputX.append(path.secondary);
                y += 5;
            }
            Path path = drive(direction * diffX);
            outputX.append(path.primary);
            outputY.append(path.secondary);
            x += direction * diffX;
        } else {
            int direction = y < stationY ? 1 : -1;
            boolean collision = isAstroidInTheWayY(x, y, stationY, astroidX, astroidY);
            if (collision) {
                //check which is better, y from station
                Path path = drive(5);
                outputX.append(path.primary);
                outputY.append(path.secondary);
                x += 5;
            }
            Path path = drive(direction * diffY);
            outputY.append(path.primary);
            outputX.append(path.secondary);
            y += direction * diffY;
        }
        return iteration(String.valueOf(outputX), String.valueOf(outputY), x, y, stationX, stationY, astroidX, astroidY);
    }

    private static boolean isAstroidInTheWayX(int x, int y, int stationX, int astroidX, int astroidY) {
        if (astroidY <= y + 2 && astroidY >= y - 2) {
            if ((astroidX > x && astroidX < stationX) || (astroidX < x && astroidX > stationX)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAstroidInTheWayY(int x, int y, int stationY, int astroidX, int astroidY) {
        if (astroidX <= x + 2 && astroidX >= x - 2) {
            if ((astroidY > y && astroidY < stationY) || (astroidY < y && astroidY > stationY)) {
                return true;
            }
        }
        return false;
    }


    private static Path drive(int distance) {

        int currentPace = 0;

        int maxCounter = 0;

        StringBuilder primaryBuilder = new StringBuilder();
        StringBuilder secondaryBuilder = new StringBuilder();

        primaryBuilder.append("0 ");
        secondaryBuilder.append("0 ");

        int iterations = (int) Math.abs(Math.ceil((double) distance / 2));

        if (distance < 0) {
            iterations = (int) Math.abs(Math.floor((double) distance / 2));
        }

        for (int j = 0; Math.abs(j) < iterations; j++) {
            if (currentPace == 0) {
                if (distance > 0) {
                    currentPace = 5;
                } else {
                    currentPace = -5;
                }
            } else if (currentPace == 1 || currentPace == -1) {
                maxCounter++;
            } else if (currentPace < 0) {
                currentPace++;
            } else {
                currentPace--;
            }

            secondaryBuilder.append("0 ".repeat(Math.abs(currentPace)));


            primaryBuilder.append(currentPace);
            primaryBuilder.append(" ");
        }

        int f = 0;

        int iterations2 = (int) Math.abs(Math.floor((double) distance / 2));

        if (distance < 0) {
            iterations2 = (int) Math.abs(Math.ceil((double) distance / 2));
        }

        for (int j = 0; j < iterations2; j++) {
            if (f == 0 && distance % 2 == 0) {
                f = 1;
            } else if (currentPace == 5 || currentPace == -5) {
                currentPace = 0;
            } else if (currentPace == 1 || currentPace == -1) {
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
            secondaryBuilder.append("0 ".repeat(Math.abs(currentPace)));

            primaryBuilder.append(currentPace);
            primaryBuilder.append(" ");
        }

        primaryBuilder.append("0 ");
        secondaryBuilder.append("0 ");
        return new Path(
                String.valueOf(primaryBuilder),
                String.valueOf(secondaryBuilder)
        );
    }
}
