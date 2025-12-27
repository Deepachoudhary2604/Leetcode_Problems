class Solution {
    public String resultingString(String s) {
        Stack<Character> st = new Stack<Character>();
        for(char c:s.toCharArray()){
            if(st.isEmpty())
                st.push(c);
            else{
                int top = st.peek()-'a';
                int curr = c-'a';
                int left = (curr==0)?25:(curr-1);
                int right = (curr==25)?0:(curr+1);
                if(top == left || top == right)
                    st.pop();
                else st.push(c);
                
            }
        }
        StringBuilder ans = new StringBuilder("");
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}