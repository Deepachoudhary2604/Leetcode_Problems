class Solution {
    HashSet<List<Integer>> set=new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        helper(nums,ans,l1,0);
        return ans;
    }
    public void helper(int[] nums,List<List<Integer>> ans,List<Integer> l1,int idx){
        if(idx==nums.length){
            if(!set.contains(new ArrayList<>(l1))){
                ans.add(new ArrayList<>(l1));
                set.add(new ArrayList<>(l1));
            }
            return;
        }
        l1.add(nums[idx]);
        helper(nums,ans,l1,idx+1);
        l1.remove(l1.size()-1);
        helper(nums,ans,l1,idx+1);
    }
}