class Solution {
    HashSet<List<Integer>> set=new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        helper(candidates,ans,l1,target,0);
        return ans;
    }
    public void helper(int[] arr,List<List<Integer>> ans,List<Integer> l1,int target,int idx){
        if(target==0){
            if(!set.contains(new ArrayList<>(l1))){
                ans.add(new ArrayList<>(l1));
                set.add(new ArrayList<>(l1));
            }
            return;
        }
        if(idx==arr.length || target<0){
            return;
        }
        l1.add(arr[idx]);
        helper(arr,ans,l1,target-arr[idx],idx+1);
        helper(arr,ans,l1,target-arr[idx],idx);
        l1.remove(l1.size()-1);
        helper(arr,ans,l1,target,idx+1);
    }
}