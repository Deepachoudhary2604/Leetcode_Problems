class Solution {
    public int totalFruit(int[] fruits) {
        int i=0;
        int j=0;
        int n=fruits.length;
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        while(j<n){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            if(map.size()<=2){
                count=Math.max(count,j-i+1);
            }
            else{
                int c=map.get(fruits[i]);
                if(c==1){
                    map.remove(fruits[i]);

                }
                else{
                    map.put(fruits[i],c-1);
                }
                i++;
            }
            j++;
        }
        return count;
    }
}