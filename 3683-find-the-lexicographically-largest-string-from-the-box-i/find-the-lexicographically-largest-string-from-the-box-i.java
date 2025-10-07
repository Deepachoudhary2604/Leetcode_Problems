class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1){
            return word;
        }
        int n=word.length();
        String ans="";
        int possible_longest=word.length()-(numFriends-1);
        for(int i=0;i<word.length();i++){
            int taken = Math.min(possible_longest, n - i);
            String sub = word.substring(i, i + taken);
            if (sub.compareTo(ans) > 0) {
                ans = sub; // keep lexicographically larger string
            }
        }
        return ans;
    }
}