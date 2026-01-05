class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',' || ch == '(') continue;

            if (ch != ')') {
                st.push(ch);
            } else {
                boolean hasTrue = false;
                boolean hasFalse = false;

                while (st.peek() != '&' && st.peek() != '|' && st.peek() != '!') {
                    char val = st.pop();
                    if (val == 't') hasTrue = true;
                    if (val == 'f') hasFalse = true;
                }

                char op = st.pop();

                if (op == '!') {
                    st.push(hasTrue ? 'f' : 't');
                } else if (op == '&') {
                    st.push(hasFalse ? 'f' : 't');
                } else if (op == '|') {
                    st.push(hasTrue ? 't' : 'f');
                }
            }
        }

        return st.peek() == 't';
    }
}
