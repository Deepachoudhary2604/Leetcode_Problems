class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l1=new ArrayList<>();
        parantheses(n,0,0,"",l1);
        return l1;
    }
    public static void parantheses(int n,int open,int close,String ans,List<String> l1){
        if(open>n || close>open){
            return;
        }
        if(open==n && close==n){
            l1.add(ans);
        }
        parantheses(n,open+1,close,ans+"(",l1);
        parantheses(n,open,close+1,ans+")",l1);
    }
}