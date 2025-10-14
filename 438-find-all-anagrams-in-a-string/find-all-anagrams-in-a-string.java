class Solution {
    public List<Integer> findAnagrams(String s2, String s1) {
        List<Integer> ans=new ArrayList<>();
        if (s1.length() > s2.length()) return ans;
        int[] arr1=new int[26];
        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i)-'a']++;
        }
        int[] arr2=new int[26];
        int i=0;
        int j=0;
        while(j<s2.length()){
            arr2[s2.charAt(j)-'a']++;
            if(j-i+1>s1.length()){
                arr2[s2.charAt(i)-'a']--;
                i++;
            }
            if(j-i+1==s1.length() && Arrays.equals(arr1,arr2)){
                ans.add(i);
            }
            j++;
        }
        return ans;
    }
}