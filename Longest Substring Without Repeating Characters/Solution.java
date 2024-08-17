import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lenS = s.length();
        HashMap<Character, Integer> charMap = new HashMap<>();
        int i = 0;
        int longest = 0;
        // Move the second pointer j to iterate through the string
        for (int j = 0; j < lenS; j++) {
            char c = s.charAt(j);
            // If exists increment count else default to 0 and increment
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            // Adjust the window to ensure all characters are unique
            // Remove duplicates and move the first pointer i until there is no duplicate
            while (charMap.get(c) > 1) {
                char l = s.charAt(i);
                charMap.put(l, charMap.get(l) - 1);
                // Remove the character from the map if its count becomes 0
                if (charMap.get(l) == 0) {
                    charMap.remove(l);
                }
                // Move the left pointer to shrink the window
                i++;
            }
            // Compute longest based on the adjusted window
            longest = Math.max(longest, j - i + 1);
        }
        return longest;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution sol = new Solution();
        System.out.println("Input String: " + s);
        System.out.println("Length of longest Substring Without Repeating Characters is: " + sol.lengthOfLongestSubstring(s));
    }
}
