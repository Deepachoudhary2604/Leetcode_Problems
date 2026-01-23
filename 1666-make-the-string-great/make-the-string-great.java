class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(!st.isEmpty() && (int)(Math.abs(ch-st.peek()))==32){
                st.pop();
                continue;
            }
            st.push(ch);
        }

        StringBuilder ans = new StringBuilder();
        for (char c : st) ans.append(c);
        return ans.toString();
    }
}
