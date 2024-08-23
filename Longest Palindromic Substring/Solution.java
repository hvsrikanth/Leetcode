class Solution {
    String getPalindrome(int sLen, String s, int i, int j) {
        int left = i;
        int right = j;
        // Expand the palindrome from i and j using left and right pointers
        // Move left towards left and right towards right
        while (left >= 0 && right <= sLen - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Increment left pointer to adjust its value
        // as it has changed before while loop failure
        // right is exclusive in substring call and hence ok
        // Return the palindrome
        return s.substring(left + 1, right);
    }

    public String longestPalindrome(String s) {
        int sLen = s.length();
        String longest = "";
        if (sLen > 0) {
            longest = s.substring(0, 1);
            for (int i = 0; i < sLen - 1; i++) {
                // Odd length case
                String p1 = getPalindrome(sLen, s, i, i);
                if (p1.length() > longest.length()) {
                    longest = p1;
                }
                // Even length case
                String p2 = getPalindrome(sLen, s, i, i + 1);
                if (p2.length() > longest.length()) {
                    longest = p2;
                }
            }
        }
        return longest;        
    }
    public static void main(String[] args) {
        String s = "zxcabebad";
        Solution sol = new Solution();
        System.out.println("Longest palindromic substring in s: " + s + " is: " + sol.longestPalindrome(s));
    }
}