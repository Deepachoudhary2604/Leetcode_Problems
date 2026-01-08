class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int max=Integer.MIN_VALUE;
        for(int n:nums){
            set.add(n);
            max=Math.max(n,max);
        }
        for(int i=1;i<=max;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        if(max<=0){
            return 1;
        }
        return max+1;
    }
}