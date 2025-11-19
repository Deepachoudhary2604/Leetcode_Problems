class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        int[] trustby=new int[n+1];
        int[] truston=new int[n+1];
        for(int i=0;i<trust.length;i++){
            int a=trust[i][0];
            int b=trust[i][1];
            trustby[a]++;
            truston[b]++;
        }
        for(int i=0;i<trustby.length;i++){
            if(truston[i]==n-1 && trustby[i]==0){
                return i;
            }
        }
        return -1;
    }
}