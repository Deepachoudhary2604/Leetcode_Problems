class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            int[] freq=new int[26];
            for(int j=0;j<strs[i].length();j++){
                freq[strs[i].charAt(j)-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<freq.length;j++){
                sb.append(freq[j]+" ");
            }
            String key=sb.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        List<List<String>> ans=new ArrayList<>();
        for(String key:map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
}