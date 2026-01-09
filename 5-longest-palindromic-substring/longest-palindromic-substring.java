class Solution {
    public String longestPalindrome(String s) {
        String str="";
        int ans=Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(s,i,j)){
                    ans=Math.max(ans,j-i+1);
                    if(ans>max){
                        max=ans;
                        str=s.substring(i,j+1);
                    }
                }
            }

        }
        return str;
    }
    public boolean isPalindrome(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}