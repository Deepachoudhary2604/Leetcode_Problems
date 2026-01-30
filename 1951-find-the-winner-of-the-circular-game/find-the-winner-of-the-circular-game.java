class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            ans.add(i);
        }
        int i=0;
        while(ans.size()>1){
            int idx=(i+k-1)%ans.size();
            ans.remove(idx);
            i=idx;
        }
        return ans.get(0);
    }
}