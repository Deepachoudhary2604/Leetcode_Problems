class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String ch:strs){
            char[] arr=ch.toCharArray();
            Arrays.sort(arr);
            String newStr=new String(arr);
            if(map.containsKey(newStr)){
                map.get(newStr).add(ch);
            }
            else{
                map.put(newStr,new ArrayList<>());
                map.get(newStr).add(ch);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(String key:map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
}