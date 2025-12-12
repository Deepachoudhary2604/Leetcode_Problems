class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> l1=new ArrayList<>();
       helper(l1,n,0,0,"");
       return l1;
    }
    public void helper(List<String> l1,int n,int open,int close,String s){
        if(n==open && n==close){
            l1.add(s);
            return;
        }
        if(open>n || close>open){
            return;
        }
        helper(l1,n,open+1,close,s+"(");
        helper(l1,n,open,close+1,s+")");

    }
}