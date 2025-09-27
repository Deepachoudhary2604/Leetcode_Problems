class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0;
        
        int max=0;
        for(int i=0;i<fruits.length;i++){
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while(map.size()>2){
                int count=map.get(fruits[l]);
                if(count==1){
                    map.remove(fruits[l]);
                }
                else{
                    map.put(fruits[l],count-1);
                    
                }
                l++;
                
            }
            max=Math.max(max,i-l+1);
            

        }
        return max;
    }
}