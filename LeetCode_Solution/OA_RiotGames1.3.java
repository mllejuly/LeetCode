import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.Scanner;

public class Solution3 {

    static String[][] convertGarden(int w, int h, String str) {
        String[] s = str.split(",");
        String[][] layout = new String[w][h];
        
        // default "B"
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                layout[i][j] = "B";
            }
        }
        
        // insert Flowers
        for (int i = 0; i < s.length - 2; i++) {
            if (s[i].equals("F")) {
                layout[Integer.valueOf(s[i + 2])][Integer.valueOf(s[i + 1])] = "F";
            }
            if (s[i].equals("C")) {
                layout[Integer.valueOf(s[i + 2])][Integer.valueOf(s[i + 1])] = "C";
            }
            if (s[i].equals("D")) {
                layout[Integer.valueOf(s[i + 2])][Integer.valueOf(s[i + 1])] = "D";
            }
            if (s[i].equals("E")) {
                layout[Integer.valueOf(s[i + 2])][Integer.valueOf(s[i + 1])] = "E";
            }
            if (s[i].equals("W")) {
                layout[Integer.valueOf(s[i + 2])][Integer.valueOf(s[i + 1])] = "W";
            }            
        }
        
        return layout;
    }
    
    static boolean isValidAction(String[][] layout) {
        Stack<String> flowerCart = new Stack<String>(); 
        Scanner planScan = new Scanner(System.in);
        while (planScan.hasNextLine()) {
            String plan = planScan.nextLine();
            // System.out.println(plan);
            String [] s = plan.split(",");
            // Pick Up
            if (s[0].equals("Pick up")) {
                // flower available to pick up
                if (layout[Integer.valueOf(s[3])][Integer.valueOf(s[2])].equals(s[1])) {
                    // pick up flower in garden
                    layout[Integer.valueOf(s[3])][Integer.valueOf(s[2])] = "B";
                    // push picked flower in flowerCart
                    flowerCart.push(s[1]);
                } else {
                    textDisplay(layout);
                    return false;
                }
            }
            // Plant
            if (s[0].equals("Plant")) {
                // pop top flower in flowerCart
                String f = flowerCart.pop();
                // garden position available && flowerCart top element available
                if (layout[Integer.valueOf(s[3])][Integer.valueOf(s[2])].equals("B") && s[1].equals(f)) {
                    // plant flower in garden
                    layout[Integer.valueOf(s[3])][Integer.valueOf(s[2])] = f;
                } else {
                    textDisplay(layout);
                    return false;
                } 
            }
        }
        textDisplay(layout);
        return true;
    }
    
    // print new Garden Map
    static void textDisplay (String[][] layout) {
        int h = layout.length;
        int w = layout[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(layout[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int w = 3;
        int h = 3;
        String str = "3,3,C,1,1,D,2,2,F,1,2,E,2,1,D,0,1";
        String[][] layout = convertGarden(w,h,str);
        System.out.println(isValidAction(layout));
    }
}
