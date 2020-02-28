import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.Scanner;

public class Solution3 {

    static String[][] convertGarden(String input) {
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
        
        // insert Flowers and Ivy
        for (int i = 0; i < s.length - 2; i++) {
            if (s[i].equals("F")) {
                layout[Integer.valueOf(s[i + 2])][Integer.valueOf(s[i + 1])] = "F";
            }
            if (s[i].equals("I")) {
                layout[Integer.valueOf(s[i + 2])][Integer.valueOf(s[i + 1])] = "I";
            }
        }
        
        
        Queue<String> queue = new LinkedList<String>();
        // bfs(layout, pos);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (layout[i][j].equals("I")) {
                    String pos = "" + Integer.toString(i) + Integer.toString(j);
                    bfs(layout, pos);
                }
            }
        }
        return layout;
    }
    
    static String[][] bfs (String[][]layout, String s) {
 
        int x = s.charAt(0) - '0';
        int y = s.charAt(1) - '0';
        int h = layout.length;
        int w = layout[0].length;
        
        boolean a = (x != 0 && layout[x-1][y].equals("F"));
        boolean b = (x != h - 1 && layout[x+1][y].equals("F"));
        boolean c = (y != 0 && layout[x][y-1].equals("F"));
        boolean d = (y != w - 1 && layout[x][y+1].equals("F"));
        boolean meetF = a || b || c || d;
        if (meetF) {
            return layout;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.add(s);
        
        Set<String> posVisited = new HashSet<String>();
        while (queue.size() != 0) {            
            // dequeue currentIvy
            s = queue.poll();
            if (!posVisited.contains(s)) {
                x = s.charAt(0) - '0';
                y = s.charAt(1) - '0';
                // ↑
                if (x != 0 && layout[x-1][y].equals("B")) {
                    layout[x-1][y] = "I";
                    String pos = "" + Integer.toString(x-1) + Integer.toString(y);
                    posVisited.add(pos);
                    queue.add(pos);
                }
                // ↓
                if (x != h - 1 && layout[x+1][y].equals("B")) {
                    layout[x+1][y] = "I";
                    String pos = "" + Integer.toString(x+1) + Integer.toString(y);
                    posVisited.add(pos);
                    queue.add(pos);            
                }
                // ←
                if (y != 0 && layout[x][y-1].equals("B")) {
                    layout[x][y-1] = "I";
                    String pos = "" + Integer.toString(x) + Integer.toString(y-1);
                    posVisited.add(pos);
                    queue.add(pos);
                }
                // →
                if (y != w - 1 && layout[x][y+1].equals("B")) {
                    layout[x][y+1] = "I";
                    String pos = "" + Integer.toString(x) + Integer.toString(y+1);
                    posVisited.add(pos);
                    queue.add(pos);
                }
            }
        }
        return layout;
    }
    
    // print new Garden Map
    static void displayGarden (String[][] layout) {
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
