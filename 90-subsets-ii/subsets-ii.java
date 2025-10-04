class Solution {
      Set<List<Integer>> set=new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>  ans1=new ArrayList<>();
        List<Integer> ans2=new ArrayList<>();
        solve(nums,0,ans1,ans2);
        if(!set.contains(new ArrayList<>())){
            ans1.add(new ArrayList<>());
        }
        return ans1;
    }
    public   void solve(int[] nums,int idx,List<List<Integer>> ans1,List<Integer> ans2){
        if(idx==nums.length){
            if(!set.contains(ans2)){
                set.add(new ArrayList<>(ans2));
                ans1.add(new ArrayList<>(ans2));
            }
            return;
        }
        solve(nums,idx+1,ans1,ans2);
        ans2.add(nums[idx]);
        solve(nums,idx+1,ans1,ans2);
        ans2.remove(ans2.size()-1);
    }
}