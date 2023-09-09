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

    /*
     * Complete the 'strangeSort' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY mapping
     *  2. STRING_ARRAY nums
     */

    public static List<String> strangeSort(List<Integer> mapping, List<String> nums) {
        // Write your code here
        Result res = new Result();
        
        int[] mapList = mapping.stream().mapToInt(i -> i).toArray();
        String numList[] = nums.toArray(new String[0]);
        String[] resultList = res.help(mapList, numList);

        List<String> result = new ArrayList<>();
        result = Arrays.asList(resultList);

        return result;
    }

    public class sortObj{
        String ori;
        String real;
        int pos;

        sortObj(String s, int p){
            this.ori = s;
            this.pos = p;
        }
    }
    
    public String[] help(int[] mapping, String nums[]) {
        if(nums == null || nums.length == 0) {
            return new String[0];
        }
        
        List<sortObj> ls = new ArrayList<>();
        // Record real
        HashMap<Character, Character> map = new HashMap<>();

        for(int i : mapping) {
            map.put((char)('0' + mapping[i]), (char)('0' + i));
        }
        
        for(int i = 0; i < nums.length; i++) {
            sortObj obj = new sortObj(nums[i],i);
            StringBuilder sb = new StringBuilder();
            boolean isZero = true;

            for(char c : nums[i].toCharArray()) {
                char correctc = map.get(c);
                if(isZero && Character.getNumericValue(correctc) != 0)
                    isZero = false;
                if(!isZero)
                    sb.append(correctc);
            }
            
            obj.real = sb.toString();
            ls.add(obj);
        }

        Collections.sort(ls, new Comparator<sortObj>() {
            public int compare(sortObj a, sortObj b) {
                if(a.real.length() == b.real.length()) {
                    return a.real.compareTo(b.real);
                }
                
                return a.real.length() - b.real.length();
            }
        });
        
        String[] res = new String[ls.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = ls.get(i).ori;
        }
        
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int mappingCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> mapping = IntStream.range(0, mappingCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int numsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> nums = IntStream.range(0, numsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.strangeSort(mapping, nums);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
