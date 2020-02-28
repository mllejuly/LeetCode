class MyStack {

    private Queue<Integer> q = new LinkedList<>();
    
    /** Initialize your data structure here. */
    public MyStack() {

    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        int s = q.size();
        while (s > 1) {
            q.add(q.remove());
            s--;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {     
        return q.remove();   
    }
    
    /** Get th  e top element. */
    public int top() {
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }

}
