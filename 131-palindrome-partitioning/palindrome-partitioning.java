class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> curr=new ArrayList<>();
        solve(s,0,curr,ans);
        return ans;
    }
    public void solve(String s,int idx,List<String> curr,List<List<String>> ans){
        if(idx==s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s.substring(idx,i+1))){
                curr.add(s.substring(idx,i+1));
                solve(s,i+1,curr,ans);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str){
        int s=0;
        int e=str.length()-1;
        while(s<=e){
            if(str.charAt(s)!=str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}