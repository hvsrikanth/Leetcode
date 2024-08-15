import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Size of the input array
        int size = nums.length;
        // HashMap to store the compliment of current element w.r.t target
        Map<Integer, Integer> map = new HashMap<>();
        // Traverse the input array and check if the current element is in the HashMap
        // If it exists, then we found the elements adding to the target
        // Else store the compliment of the current element in the HashMap
        for (int i = 0; i < size; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                return new int[]{i, map.get(nums[i])};
            }
        }
        return new int[]{};
    }
    
    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = {1, 10, 8, 7, 11, 19, 2, 5, 9, 12};
        int target = 22;
        Solution sol = new Solution();
        int[] result = sol.twoSum(A, target);
        printArray(result);
    }
}
