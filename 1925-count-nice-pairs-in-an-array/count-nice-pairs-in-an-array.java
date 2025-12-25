class Solution {
    static final int MOD = 1_000_000_007;
    public int countNicePairs(int[] nums) {
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int diff = num - rev(num);

            int count = map.getOrDefault(diff, 0);
            ans = (ans + count) % MOD;

            map.put(diff, count + 1);
        }

        return (int) ans;
    }
    public static int rev(int n){
        int ans=0;
        while(n>0){
            int r=n%10;
            ans=ans*10+r;
            n=n/10;
        }
        return ans;
    }
}