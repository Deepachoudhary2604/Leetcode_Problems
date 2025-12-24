class Solution {
    public String smallestString(String s) {
        char[] a = s.toCharArray();
        int i = 0;

        // skip all leading 'a'
        while (i < a.length && a[i] == 'a') {
            i++;
        }

        // if all characters are 'a'
        if (i == a.length) {
            a[a.length - 1] = 'z';
        } else {
            // decrement until we hit 'a'
            while (i < a.length && a[i] != 'a') {
                a[i] = (char)(a[i] - 1);
                i++;
            }
        }

        return new String(a);
    }
}