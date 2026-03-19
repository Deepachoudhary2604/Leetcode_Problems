class Solution {
    public int leastInterval(char[] tasks, int n) {
        int max=Integer.MIN_VALUE;
        int[] freq=new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        for(int i=0;i<freq.length;i++){
            max=Math.max(max,freq[i]);
        }
        int ans=(max-1)*(n+1);
        for(int i=0;i<26;i++){
            if(freq[i]==max){
                ans++;
            }
        }
        return  Math.max(tasks.length,ans);
    }
}