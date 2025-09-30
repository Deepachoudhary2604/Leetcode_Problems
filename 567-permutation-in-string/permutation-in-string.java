class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n>m){
            return false;
        }
        int[] arr1=new int[26];
        for(int i=0;i<n;i++){
            arr1[s1.charAt(i)-'a']++;
        }
        int[] arr2=new int[26];
        int i=0;
        int j=0;
        while(j<m){
            arr2[s2.charAt(j)-'a']++;
            if(j-i+1>n){
                arr2[s2.charAt(i)-'a']--;
                i++;
            }
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
            j++;
        }
        return false;
    }
}