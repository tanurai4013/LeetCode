class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] lastSeen = new int[30];
        int[] res = new int[n];
        Arrays.fill(lastSeen, -1);  // Initialize all to -1
        
        for (int i = n - 1; i >= 0; i--) {
            // Update the latest position for each set bit
            for (int bit = 0; bit < 30; bit++) {
                if ((nums[i] & (1 << bit)) != 0) {
                    lastSeen[bit] = i;
                }
            }
            int maxLen = 1;
            for (int bit = 0; bit < 30; bit++) {
                if (lastSeen[bit] != -1) {
                    maxLen = Math.max(maxLen, lastSeen[bit] - i + 1);
                }
            }
            res[i] = maxLen;
        }
        return res;
    }
}
