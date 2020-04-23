package sapient;

import java.util.Stack;

public class CheckBalancedParenthesis {

    private boolean ifMatchingPair(Character c1, Character c2) {
        if (c1 == '(' && c2 == ')')
            return true;
        else if (c1 == '{' && c2 == '}')
            return true;
        else if (c1 == '[' && c2 == ']')
            return true;
        else
            return false;
    }

    public boolean isBalanced(char[] ch) {
        Stack<Character> st = new Stack<>();
        boolean isBalanced = true;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
                st.push(ch[i]);
            } else if (ch[i] == ')' || ch[i] == '}' || ch[i] == ']') {
                if (st.isEmpty()) {
                    return false;
                }
                Character c1 = st.pop();
                if (!ifMatchingPair(c1,ch[i])) {
                    return false;
                }
            }
        }

        if (!st.isEmpty()) {
            return false;
        }
        return isBalanced;
    }


    public static void main(String[] args) {
        char ch[] = {'{', '(', ')', '}', '[', ']','{'};
        CheckBalancedParenthesis c = new CheckBalancedParenthesis();
        System.out.println(c.isBalanced(ch));

    }
}
