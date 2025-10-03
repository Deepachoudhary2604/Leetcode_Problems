class Solution {
    static Set<List<Integer>> set=new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> l1=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        combination(candidates,target,l1,0,ans);
        return ans;
        
    }
    public static void combination(int[] candidate,int target,List<Integer> l1,int idx,List<List<Integer>> ans){
        if(target==0){
            if(!set.contains(l1)){
                ans.add(new ArrayList<>(l1));
                set.add(l1);
            }
            return;
        }
        if(idx==candidate.length || target<0){
            return;
        }
        l1.add(candidate[idx]);
        combination(candidate,target-candidate[idx],l1,idx+1,ans);
        combination(candidate,target-candidate[idx],l1,idx,ans);
        l1.remove(l1.size()-1);
        combination(candidate,target,l1,idx+1,ans);
    }
}