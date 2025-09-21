class Solution {
    public void Subset(int nums[], int idx, List<List<Integer>> res,List<Integer> list ){
        res.add(new ArrayList<>(list));
        for(int i=idx; i<nums.length; i++){
            if(i>idx && nums[i]==nums[i-1]) continue;

            list.add(nums[i]);
            Subset(nums,i+1,res,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Subset(nums,0,res,list);
        return res;
    }
}