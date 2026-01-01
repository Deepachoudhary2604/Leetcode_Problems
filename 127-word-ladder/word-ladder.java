class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }
        Set<String> set=new HashSet<>();
        set.add(beginWord);
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        int ans=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                String str=q.poll();
                char[] temp=str.toCharArray();
                for(int i=0;i<temp.length;i++){
                    char original=temp[i];
                    for(char ch='a';ch<='z';ch++){
                        temp[i]=ch;
                       
                        String newStr=new String(temp);
                        if(newStr.equals(endWord)){
                            return ans+1;
                        }
                        if(wordSet.contains(newStr) && !set.contains(newStr)){
                            set.add(newStr);
                            q.add(newStr);
                        }
                    }
                    temp[i]=original;
                }
                size--;
            }
            ans++;
        }
        return 0;
    }

}