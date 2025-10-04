class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> l1=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        combination(candidates,target,l1,0,ans);
        return ans;
        
    }
    public void combination(int[] candidate,int target,List<Integer> l1,int idx,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(l1));
            return;
        }
        if(idx==candidate.length || target<0){
            return;
        }
        l1.add(candidate[idx]);
        combination(candidate,target-candidate[idx],l1,idx+1,ans);
        l1.remove(l1.size()-1);

        
        int next = idx + 1;
        while (next < candidate.length && candidate[next] == candidate[idx]) {
            next++;
        }
        combination(candidate,target,l1,next,ans);
        
        
    }
}