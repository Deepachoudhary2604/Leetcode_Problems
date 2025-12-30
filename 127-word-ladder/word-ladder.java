class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }
        Set<String> set=new HashSet<>();
        set.add(beginWord);
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            ans++;
            while(size>0){
                String val=q.poll();
                char[] temp=val.toCharArray();
                for(int i=0;i<temp.length;i++){
                    char original=temp[i];
                    for(char ch='a';ch<='z';ch++){
                        temp[i]=ch;
                        String newStr=new String(temp);
                        if(newStr.equals(endWord)){
                            return ans+1;
                        }
                        if(wordSet.contains(newStr) && !set.contains(newStr)){
                            q.add(newStr);
                            set.add(newStr);
                        }
                    }
                    temp[i]=original; 
                }
                size--;
            }
        }
        return 0;
    }

}