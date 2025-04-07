class Solution {
    public void moveZeroes(int[] nums) {
        // Left is used to track 0's
        int left = 0;
        // Iterate through the array with the right pointer
        for (int right = 0; right < nums.length; right++) {
            // When right is pointing to non-zero element
            // and left is pointing to zero
            if (nums[right] != 0) {
                if (nums[left] == 0) {
                    // Move non-zero element to the left pointer's position
                    nums[left] = nums[right];
                    // Now set element at right pointer's position to 0
                    nums[right] = 0;
                }
                // Increment the left pointer only when we move a non-zero element
                left++;
            }
        }
    }

    public void printArray(int[] A) {
        for(int x : A) {
            System.out.print(x + " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        int nums[] = {0,1,0,3,12};
        Solution sol = new Solution();
        sol.moveZeroes(nums);
        sol.printArray(nums);
    }
}