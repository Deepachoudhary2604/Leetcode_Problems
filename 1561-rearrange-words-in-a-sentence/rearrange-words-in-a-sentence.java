class Solution {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");

        Arrays.sort(words, Comparator.comparingInt(String::length));

        String joined = String.join(" ", words).toLowerCase();

        String result = joined.substring(0, 1).toUpperCase() + joined.substring(1);

        return result;
    }
}