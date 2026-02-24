class Solution {
    HashSet<Integer> set=new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        helper(nums,l1,l2);
        return l1;
    }
    public void helper(int[] nums,List<List<Integer>> l1,List<Integer> l2){
        if(l2.size()==nums.length){
            l1.add(new ArrayList<>(l2));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                l2.add(nums[i]);
                helper(nums,l1,l2);
                set.remove(nums[i]);
                l2.remove(l2.size()-1);
            }
        }
    }
}