class Solution {
    public List<Integer> findAnagrams(String s2, String s1) {
        List<Integer> a=new ArrayList<>();
        if (s1.length() > s2.length()) return a;
        int i=0;
        int j=s1.length()-1;
        char[] arr=s1.toCharArray();
        Arrays.sort(arr);
        String s=new String(arr);
        while(j<=s2.length()-1){
            String ans=s2.substring(i,j+1);
            char[] ans1=ans.toCharArray();
            Arrays.sort(ans1);
            String ans2=new String(ans1);
            if(s.equals(ans2)){
                a.add(i);
            }
            i++;
            j++;
        }
        return a;
    }
}