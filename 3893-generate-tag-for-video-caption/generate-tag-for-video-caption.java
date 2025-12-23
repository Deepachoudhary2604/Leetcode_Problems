class Solution {
    public String generateTag(String caption) {
        String ans = "#";

        for (int i = 0; i < caption.length(); i++) {

            if (ans.length() == 100) break;

            char ch = caption.charAt(i);

            if (ch == ' ') {
                continue;
            }

            // first character after #
            if (ans.length() == 1) {
                ans += Character.toLowerCase(ch);
            }
            // character after space
            else if (i > 0 && caption.charAt(i - 1) == ' ') {
                ans += Character.toUpperCase(ch);
            }
            else {
                ans += Character.toLowerCase(ch);
            }
        }
        return ans;
    }
}