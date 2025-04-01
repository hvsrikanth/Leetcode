import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>(candies.length);
        int maxCandies = Integer.MIN_VALUE;
        // Find maximum candies in the candies vector
        for(int x : candies) {
            maxCandies = Math.max(maxCandies, x);
        }
        // Now set the greatest vector with true or false
        // when extra candies are given to a kid at ith position
        for(int x : candies) {
            result.add(x + extraCandies >= maxCandies);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> result = sol.kidsWithCandies(candies, extraCandies);
        for(boolean x : result) {
            System.out.print(x + " ");
        }
    }
}