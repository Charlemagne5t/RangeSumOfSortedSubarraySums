import java.util.Arrays;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = (int )1e9 + 7;
        int[] sum = new int[n * (n + 1) / 2];
        int k = 0;
        int[] dp = new int[nums.length];
        int s = 0;
        for(int i = 0; i < nums.length; i++) {
            s = (s + nums[i]) % mod;
            dp[i] = s;
            sum[k++] = dp[i];
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                dp[j] -= nums[i];
                sum[k++] = dp[j];
            }
        }
        Arrays.sort(sum);
        
        int res = 0;
        for(int i = left - 1; i < right; i++) {
            res = (res + sum[i]) % mod;
        }
        return res ;
    }
}