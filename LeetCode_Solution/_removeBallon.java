// "static void main" must be defined in a public class.
class Solution {
    public static int maximumMove(String S) {
        int[] count = new int[26];
        for (char c : S.toCharArray()) {
            count[c - 'A']++;
        }

        List<Integer> countList = new ArrayList<Integer>(); 
        
        int b = count['B' - 'A'];
        countList.add(b);
        int a = count['A' - 'A'];
        countList.add(a);
        int l = count['L' - 'A'] / 2;
        countList.add(l);
        int o = count['O' - 'A'] / 2;
        countList.add(o);
        int n = count['N' - 'A'];
        countList.add(n);
        
        // sort list in natural order 
        Collections.sort(countList); 
 
        return countList.get(0);
    }
}

public class Main {
    public static void main(String[] args) {
        String S = "BAONXXOLL";
        String S1 = "BAOOLLNNOLOLGBAX";
        String S2 = "QAWABAWONL";
        int ans = Solution.maximumMove(S1);
        System.out.println(ans);
    }
}
