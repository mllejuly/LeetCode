import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    // Complete the 'PrintGardenLayout' function below.

    static String[][] convertGarden(String input) {
        if (input == null || input.length() == 0 || input.charAt(0) == '0') {
            String[][] layout = new String[0][0];
            return layout;
        }

        String[] s = input.split(",");
        
        int w = Integer.valueOf(s[0]);
        int h = Integer.valueOf(s[1]);
        
        String[][] layout = new String[w][h];
        
        // default "B"
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                layout[i][j] = "B";
            }
        }
        
        // insert Flowers and Wall
        for (int i = 0; i < s.length - 2; i++) {
            if (s[i].equals("F")) {
                layout[Integer.valueOf(s[i + 2])][Integer.valueOf(s[i + 1])] = "F";
            }
            if (s[i].equals("W")) {
                layout[Integer.valueOf(s[i + 2])][Integer.valueOf(s[i + 1])] = "W";
                
            }
        }
        
        return layout;
    }

    static void displayGarden (String[][] layout) {
        if (layout == null || layout.length == 0 || layout[0].length == 0) {
            System.out.println("");
        }
        else {
            int h = layout.length;
            int w = layout[0].length;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    System.out.print(layout[i][j]);
                }
                System.out.println("");
            }
        }
        
    }

    public static void PrintGardenLayout() {
        String input = "";
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String map = scan.nextLine();
            // System.out.println(map);
            input = input + map + ",";
        }
        
        String[][] layout = convertGarden(input);
        
        displayGarden(layout);
    }

}

public class Solution {
    public static void main(String[] args) {

        Result.PrintGardenLayout();

    }
}
