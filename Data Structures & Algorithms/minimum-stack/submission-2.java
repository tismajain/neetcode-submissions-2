class MinStack {

     Stack<Integer> st;
     Stack<Integer> min;
    public MinStack() {
        st=new Stack<>();
        min= new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(min.isEmpty())
        {
            min.push(val);
            return;
        }
        if(val<=min.peek())
        {
            min.push(val);
        }

    }
    
    public void pop() {
       int x= st.pop();
       if( x== min.peek())
        min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
