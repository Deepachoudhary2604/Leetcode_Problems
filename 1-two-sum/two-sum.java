class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int[] ans={-1,-1};
        for(int i=0;i<nums.length;i++){
            int val=target-nums[i];
            if(map.containsKey(val) && map.get(val)!=i){
                return new int[]{i,map.get(val)};
            }
        }
        return ans;
    }
}