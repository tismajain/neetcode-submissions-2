class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st=new Stack<>();
        for(int i=0;i<tokens.length;i++)
        {
           if(
                    !tokens[i].equals("+") &&
                    !tokens[i].equals("-") &&
                    !tokens[i].equals("*") &&
                    !tokens[i].equals("/")
            )
            {
                
                st.push(tokens[i]);
            }
            else
            {

                int r=Integer.parseInt(st.pop());
                int l=Integer.parseInt(st.pop());
                int val=0;
                if(tokens[i].equals("+"))
                {
                    val=l+r;
                }
                else if(tokens[i].equals("-"))
                {
                    val=l-r;
                }
                else if(tokens[i].equals("*"))
                {
                    val=l*r;
                }
                else 
                {
                    val=l/r;
                }
                st.push(String.valueOf(val));
            }
        }
        return Integer.parseInt(st.peek());
    }
}
