class MyStack {
    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        if(empty()){
            q1.add(x);
        }
        else if(q1.isEmpty()){
            q2.add(x);
        }
        else{
            q1.add(x);
        }
    }
    
    public int pop() {
        if(empty()){
            return 0;
        }
        else if(q1.isEmpty()){
            while(q2.size()>1){
                q1.add(q2.poll());
            }
            return q2.poll();
        }
        else{
            while(q1.size()>1){
                q2.add(q1.poll());
            }
            return q1.poll();
        }
    }
    
    public int top() {
        if(empty()) return 0;

        int ans;

        if(!q1.isEmpty()){
            while(q1.size() > 1){
                q2.add(q1.poll());
            }
            ans = q1.peek();
            q2.add(q1.poll());
        }
        else{
            while(q2.size() > 1){
                q1.add(q2.poll());
            }
            ans = q2.peek();
            q1.add(q2.poll());
        }

        return ans;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */