class Solution {
    public List<Integer> majorityElement(int[] arr) {
        List<Integer> ans=new ArrayList<>();
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:map.keySet()){
            if(map.get(i)>n/3){
                ans.add(i);
            }
        }
        return ans;
    }
}
