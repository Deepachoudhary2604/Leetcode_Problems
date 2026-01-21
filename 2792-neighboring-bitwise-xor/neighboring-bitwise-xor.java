class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int ans=0;
        for(int d:derived){
            ans=ans^d;
        }
        return ans==0;
    }
}