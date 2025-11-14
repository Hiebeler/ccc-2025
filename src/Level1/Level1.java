package Level1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Level1 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
