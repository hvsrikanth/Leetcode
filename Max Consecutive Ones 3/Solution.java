class Solution {
    public int longestOnes(int[] nums, int k) {
        // Two pointers left and right for expanding the window
        int left = 0;
        int right = 0;
        // Counter for 0's
        int count = 0;
        int maxLength = 0;
        // Loop thru' input array
        while(right < nums.length) {
            // Current element is 0, count it
            if(nums[right] == 0) {
                count++;
            }
            // If 0's count exceeds k then shrink the window by moving left
            while(count > k) {
                if(nums[left] == 0) {
                    // Reduce as we are leaving a 0 behind
                    count--;
                }
                left++;
            }
            // Update maxLength
            maxLength = Math.max(maxLength, right-left+1);
            // Expand the window
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        Solution sol = new Solution();
        System.out.println("Longest Ones possible is: " + sol.longestOnes(nums, k));
    }
}