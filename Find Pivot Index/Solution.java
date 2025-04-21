class Solution {
    public int pivotIndex(int[] nums) {
        int pivot = -1;
        int leftSum = 0;
        int rightSum = 0;
        // Calculate rightSum
        for(int x : nums) {
            rightSum += x;
        }
        // Now iterate nums to calculate leftSum at each i
        for(int i = 0; i < nums.length; i++) {
            // Subtract current element from rightSum
            rightSum -= nums[i];
            // Check leftSum and rightSum are equal
            if(leftSum == rightSum) {
                pivot = i;
                break;
            }
            // Add current element to leftSum
            leftSum += nums[i];
        }
        return pivot;
    }
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        Solution sol = new Solution();
        System.out.println("Pivot Index is: " + sol.pivotIndex(nums));    
    }
}