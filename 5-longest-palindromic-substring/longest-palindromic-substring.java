class Solution {
    public String longestPalindrome(String s) {
        String out=s.substring(0,1);
        int ans=1;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<=s.length();j++){
                if(ispalindrome(s.substring(i,j))){
                    int diff=j-i;
                    if(diff>ans){
                        out=s.substring(i,j);
                        ans=diff;

                    }
                }

            }
        }
        return out;
    }
    public static boolean ispalindrome(String st){
        int s=0;
        int e=st.length()-1;
        while(s<=e){
            if(st.charAt(s)!=st.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;

    }
}