public class Main {
    public static int lockUseAnalyzer(List<String> events) {
        HashSet<Integer> set = new HashSet();
        Stack<Integer> stack = new Stack();
        
        for (int i = 0; i < events.size(); i++) {
            String[] event = events.get(i).split(" ");
            String state = event[0];
            int id = Integer.parseInt(event[1]);
            // state is ACQUIRE
            if (state.equals("ACQUIRE")) {
                // acquire an already held lock
                if (set.contains(id)) {
                    return i + 1;
                }
                set.add(id);
                stack.push(id);
            } 
            // state is RELEASE
            else {
                // release a lock not acquired before or
                // release a lock in an incorrect order
                if (!set.contains(id) || stack.peek() != id) {
                    return i + 1;
                }
                set.remove(id);
                stack.pop();
            }
        }
        // nothing bad happened
        // return stack.empty() ? 0 : events.size()+1;        
        if (stack.isEmpty()) {
            return 0;
        }
        // not all lock were released upon terminating
        else {
            return events.size() + 1;
        }
    }
    
    public static void main(String[] args) {
        List<String> events1 = Arrays.asList("ACQUIRE 364", 
                                 "ACQUIRE 84", 
                                 "RELEASE 84", 
                                 "RELEASE 364");
        System.out.println(lockUseAnalyzer(events1));
        
        List<String> events2 = Arrays.asList("ACQUIRE 364", 
                                 "ACQUIRE 84", 
                                 "RELEASE 364",     
                                 "RELEASE 84");
        System.out.println(lockUseAnalyzer(events2));
        
        List<String> events3 = Arrays.asList("ACQUIRE 123",
                                 "ACQUIRE 364", 
                                 "ACQUIRE 84", 
                                 "RELEASE 84",
                                 "RELEASE 364",
                                 "ACQUIRE 456");
        System.out.println(lockUseAnalyzer(events3));
    }
}
