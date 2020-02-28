public class Main {
    public static int add1(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int score = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '7') {
                score += 1;
            }
        }
        return score;
    }
    
    public static int add3(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int score = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == '5' && nums[i+1] == '5') {
                score += 3;
            }
        }
        return score;
    }
    
    public static int addN2(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        
        if (nums.length == 1) {
            return 1;
        }
        
        int score = 0;
        int N = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] - nums[i+1] == 1) {
                N++;
            } else {
                score += (N * N);
                N = 1;
            }
        }
        score += (N * N);
        return score;
    }
    
    public static int add2(int num) {
        if (num % 3 == 0) {
            return 2;
        }
        return 0;
    }
    
    public static int add4(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int score = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] - '0') % 2 == 0) {
                score += 4;
            }
        }
        return score;
    }
    
    public static void main(String[] args) {
        int num = 765;
        int result = add1(num) + add3(num) + addN2(num) + add2(num) + add4(num);
        System.out.println(result);
        System.out.println(add1(num));
        System.out.println(add3(num));
        System.out.println(addN2(num));
        System.out.println(add2(num));
        System.out.println(add4(num));
    }
}
