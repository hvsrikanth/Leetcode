class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        // Initialize the answer array with 1
        int answer[] = new int[size];
        // Find left product and store in answer array
        // For i = 0, left product is 1
        int left_product = 1;
        for (int i = 0; i < size; ++i) {
            answer[i] = left_product;
            left_product *= nums[i];
        }
        // Find right product and update answer array
        // For i = size-1, right product is 1
        int right_product = 1;
        for (int i = size - 1; i >= 0; --i) {
            // answer[i] holds left product.
            // Now multiplied with right product
            answer[i] *= right_product;
            right_product *= nums[i];
        }
        return answer;
    }
    public static void printArray(int[] A) {
        for (int x : A) {
            System.out.print(x + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {-1, 1, 0, -3, 3};
        Solution sol = new Solution();
    
        int[] answer1 = sol.productExceptSelf(nums1);
        int[] answer2 = sol.productExceptSelf(nums2);
        printArray(answer1);
        printArray(answer2);
    }
}