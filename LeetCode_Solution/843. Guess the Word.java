/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    
    int countGuesses = 0;
    
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> words = new ArrayList<>(Arrays.asList(wordlist));
        for (int i = 0;  i < 10; i++) {
            Random random = new Random();
            String selectedWord = words.get(random.nextInt(words.size()));
            int matches = master.guess(selectedWord);
            countGuesses++;
            if (matches == 6) {
                System.out.println(String.format("You guessed the secret word correctly with %d guesses.", countGuesses));
                break;
            }
            
            List<String> updateWords = new ArrayList<>();
            for (String word : words) {
                if (getMatches(word, selectedWord) == matches) {
                    updateWords.add(word);
                }
            }
            words = updateWords;
        }
    }
    
    public int getMatches(String a, String b) {
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
    
}
