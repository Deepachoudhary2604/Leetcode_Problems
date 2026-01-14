class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<Integer> adj=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==1){
                adj.add(key);
            }
        }
        int[] arr=new int[adj.size()];
        for(int i=0;i<adj.size();i++){
            arr[i]=adj.get(i);
        }
        return arr;
    }
}