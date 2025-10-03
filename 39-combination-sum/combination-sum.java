class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> l1=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        combination(candidates,target,l1,0,ans);
        return ans;
        
    }
    public static void combination(int[] candidate,int target,List<Integer> l1,int idx,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(l1));
            return;
        }
        for(int i=idx;i<candidate.length;i++){
            if(target>=candidate[i]){
                l1.add(candidate[i]);
                combination(candidate,target-candidate[i],l1,i,ans);
                l1.remove(l1.size()-1);
            }
        }
    
    }
}