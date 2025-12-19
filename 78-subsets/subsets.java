class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> l1=new ArrayList<>();
       List<Integer> l2=new ArrayList<>();
       helper(nums,l1,l2,0);
       return l1;
    }
    public void helper(int[] nums,List<List<Integer>> l1,List<Integer> l2,int idx){
        if(idx>nums.length-1){
            l1.add(new ArrayList<>(l2));
            return;
        }
        l2.add(nums[idx]);
        helper(nums,l1,l2,idx+1);
        l2.remove(l2.size()-1);
        helper(nums,l1,l2,idx+1);

    }
}