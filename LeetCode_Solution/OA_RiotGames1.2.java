import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {

    static String[][] convertGarden(int w, int h, String str) {
        String[] s = str.split(",");
        String[][] layout = new String[w][h];
        
        // default "B"
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                layout[i][j] = "B";
            }
        }
        
        // insert "F" & "W"
        for (int i = 0; i < s.length - 2; i++) {
            if (s[i].equals("F")) {

                layout[Integer.valueOf(s[i + 2])][Integer.valueOf(s[i + 1])] = "F";
            }
            if (s[i].equals("W")) {

                layout[Integer.valueOf(s[i + 2])][Integer.valueOf(s[i + 1])] = "W";
            }            
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (layout[i][j].equals("B")) {
                    
                    String pos = String.valueOf(i) + String.valueOf(j);
                    int countF = 0;
                    for (int m = 0; m < h; m++) {
                        if (layout[m][j].equals("W")) {
                            break;
                        }
                        if (layout[m][j].equals("F")) {
                            countF++;
                        }     
                    }
                    for (int n = 0; n < w; n++) {
                        if (layout[i][n].equals("W")) {
                            break;
                        }
                        if (layout[i][n].equals("F")) {
                            countF++;
                        }     
                    }
                    map.put(pos, countF);
                }
            }
        }
        
        List<String> posList = new ArrayList<String>();
        posList = getMaxValue(map);
        
        for (int i = 0; i < posList.size(); i++) {
            int m = Character.getNumericValue(posList.get(i).charAt(0));
            int n = Character.getNumericValue(posList.get(i).charAt(1));
            layout[m][n] = "*";
        }
        
        return layout;
    }
    
    public static List<String> getMaxValue(Map<String, Integer> map) {
        List<String> posList = new ArrayList<String>();
        
        int maxValueInMap=(Collections.max(map.values()));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                posList.add(entry.getKey());
            }
        }
        return posList;
    }
    
    public static void main(String[] args) {
        // int w = 2;
        // int h = 2;
        // String str = "2,2,F,0,1,W,1,1";
        int w = 5;
        int h = 5;
        String str = "5,5,F,2,1,F,2,3,F,2,4,F,0,4";
     
        String[][] layout = convertGarden(w,h,str);
        
        // print Layout
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(layout[i][j]);
            }
            System.out.println("");
        }
        
    }

}
