class Solution {
    public int longestSubarray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int num : nums) {
            maxi = Math.max(maxi, num);
        }

        int maxLen = 0;
        int len = 0;
        for (int num : nums) {
            if (num == maxi) {
                len++;
                maxLen = Math.max(maxLen, len);
            } else {
                len = 0;
            }
        }

        return maxLen;
    }
}