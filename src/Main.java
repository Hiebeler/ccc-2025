import Level1.Level1;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        String input = fileToString("src/Level1/level1_2_large.in");
        String output = Level1.solve(input);
        System.out.println(input);
        System.out.println(output);
        stringToFile(output, "src/Level1/level1_2_large.out");
    }

    private static void stringToFile(String value, String fileName) {
        try {

            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.print(value);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String fileToString(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            return everything;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}