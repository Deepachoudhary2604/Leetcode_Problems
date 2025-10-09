class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans1=new ArrayList<>();
        List<Integer> ans2=new ArrayList<>();
        solve(nums,0,ans1,ans2);
        return ans1;
    }
    public void solve(int[] nums,int idx,List<List<Integer>> ans1,List<Integer> ans2){
        if(idx==nums.length){
            ans1.add(new ArrayList<>(ans2));
            return;
        }
        ans2.add(nums[idx]);
        solve(nums,idx+1,ans1,ans2);
        ans2.remove(ans2.size()-1);
        solve(nums,idx+1,ans1,ans2);
    }
}