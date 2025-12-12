class Solution {
    static String[] key = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> l1 = new ArrayList<>();
        if (digits.length() == 0) {
            return l1;
        }
        print(digits, "", l1, 0);
        return l1;
    }

    public static void print(String ques, String ans, List<String> l1, int idx) {
        // base case
        if (idx == ques.length()) {
            l1.add(ans);
            return;
        }

        char ch = ques.charAt(idx);
        String str = key[ch - '0']; 

        // pick each letter one by one
        for (int i = 0; i < str.length(); i++) {
            print(ques, ans + str.charAt(i), l1, idx + 1);
        }
    }
}
