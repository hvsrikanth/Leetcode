import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Size of the input array
        int size = nums.length;
        // HashMap to store the compliment of current element w.r.t target
        Map<Integer, Integer> map = new HashMap<>();
        // Traverse the input array and check if the complement is in the HashMap
        // If it exists, then we found the elements adding to the target
        // Else store the current element in the HashMap
        for (int i = 0; i < size; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return new int[]{};
    }
    
    public static void printArray(int[] arr) {
        if(arr.length == 0){
            System.out.println("[ ]");
        } else {
            System.out.println("[" + arr[0] + ", " + arr[1] + "]");
        }
     }

    public static void main(String[] args) {
        int[] A = {1, 10, 8, 7, 11, 19, 2, 5, 9, 12};
        int target = 22;
        Solution sol = new Solution();
        int[] result = sol.twoSum(A, target);
        printArray(result);
    }
}
