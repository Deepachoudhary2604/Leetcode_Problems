class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        char[] a1=s1.toCharArray();
        char[] a2=s2.toCharArray();
        char[] a3=s3.toCharArray();
        int n=Math.min(s1.length(),Math.min(s2.length(),s3.length()));
        int ans=0;
        for(int i=0;i<n;i++){
            if(a1[i]==a2[i] && a2[i]==a3[i]){
                ans++;
            }
            else{
                break;
            }
        }
        if(ans==0){
            return -1;
        }
        else{
            return a1.length-ans+a2.length-ans+a3.length-ans;
        }
    }
}