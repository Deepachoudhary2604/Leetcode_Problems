class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            if(!set.contains(num)){
                set.add(num);
            }
            else{
                set.remove(num);
            }
        }
        int j=0;
        int[] ans=new int[set.size()];
        for(int i:set){
            ans[j]=i;
            j++;
        }
        return ans;
    }
}