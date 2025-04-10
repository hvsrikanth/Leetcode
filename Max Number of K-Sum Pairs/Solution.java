import java.util.HashMap;

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        // Loop thru' the nums array to check for k sum elements
        for (int i = 0; i < nums.length; i++) {
            // Get the complement of current element
            int complement = k - nums[i];
            // Look for the complement of current element in the map
            if (map.containsKey(complement) && map.get(complement) > 0) {
                // Found the pair, increment the count
                count++;
                // Reduce complement count as we are looking for pairs
                map.put(complement, map.get(complement) - 1);
            } else {
                // Store the current element for possible pairing
                map.put(nums[i], 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,3};
        int k = 6;
        Solution sol = new Solution();
        System.out.println("Number of Operations: " + sol.maxOperations(nums, k));
    }
}