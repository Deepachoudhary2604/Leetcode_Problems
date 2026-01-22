class Solution {
    public int[] diStringMatch(String pattern) {
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[pattern.length()+1];
        int c=0;
        for (int i=0;i<=pattern.length();i++){
            if(i==pattern.length() || pattern.charAt(i)=='I'){
                ans[i]=c;
                c++;
                while(!st.isEmpty()){
                    ans[st.pop()]=c;
                    c++;
                }
            }
            else{
                st.push(i);
            }
        }
        return ans;
    }
}