class Solution {

    public boolean isValid(String s) {
        char[] stack = new char[s.length()];  // separate stack
        int top = -1;                         // initialize empty stack

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Push opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                stack[++top] = ch;
            }

            // Handle closing brackets
            else if (ch == ')' || ch == ']' || ch == '}') {
                // If stack is empty, invalid
                if (top == -1) return false;

                char x = stack[top--]; // Pop from stack

                // Check for mismatch
                if ((ch == ')' && x != '(') ||
                    (ch == ']' && x != '[') ||
                    (ch == '}' && x != '{')) {
                    return false;
                }
            }
        }

        // If stack not empty at the end, invalid
        return top == -1;
    }
}


