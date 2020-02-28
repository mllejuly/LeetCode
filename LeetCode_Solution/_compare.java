public class Main {
    public static boolean compare(String word1, String word2) {
        // String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String alphabet = "zyxwvutsrqponmlkjihgfedcba";
        int letter_index = 0;
        while (letter_index < word1.length()) {
            Character letter1 = word1.charAt(letter_index);
            Character letter2 = word2.charAt(letter_index);
            if (alphabet.indexOf(letter1) > alphabet.indexOf(letter2)) {
                return true;
            } else if (alphabet.indexOf(letter2) > alphabet.indexOf(letter1)) {
                return false;
            }
            letter_index += 1;
        }
        return true;
    }
    
    public static void main(String[] args) {
        // String word1 = "aaa";
        // String word2 = "ccc";
        String word1 = "a";
        String word2 = "b";
        System.out.println(compare(word1,word2));
        // System.out.println("Hello World!");
    }
}
