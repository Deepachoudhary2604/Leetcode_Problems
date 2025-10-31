class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int max = 0;
        for (int n : nums) {
            if (n > max) max = n;
        }

        int[] freq = new int[max + 1];
        List<Integer> res = new ArrayList<>();

        // Count frequencies
        for (int n : nums) {
            freq[n]++;
        }

        // Collect numbers appearing exactly twice
        for (int i = 0; i <= max; i++) {
            if (freq[i] == 2) {
                res.add(i);
            }
        }

        int[] arr=new int[res.size()];

        for(int i=0;i<res.size();i++){
            arr[i]=res.get(i);
        }
        return arr;
    }
}