// tag: 脸书，推特，Zenefits，Bloomberg，爱彼迎，优步，谷歌，亚马逊，微软

class Solution {
    
    // Hash table that takes are of the mappings.
    private HashMap<Character, Character> mappings;
    
    public Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')','(');
        this.mappings.put('}','{');
        this.mappings.put(']','[');
    }
    
    public boolean isValid(String s) {
        // Initialize a stack to be used in the algrithom
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // if the current character is a closing bracket
            if (this.mappings.containsKey(c)) {
                // get the top elemant of the stack
                // if the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();
                
                // if the mapping for this bracket doesn't match the stack's top element, return false
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            }
            else {
                stack.push(c);
            }
        }
        
        // if the stack still contains elements, then it is an invalid expression
        return stack.isEmpty();
    }
}
