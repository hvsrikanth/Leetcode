class Solution {
    public boolean isSubsequence(String s, String t) {
        // Two pointers i and j
        // j to iterate s
        int j = 0;
        // Iterate over the longer string t to check for 
        // presence of characters from smaller string s
        for (int i = 0; i < t.length(); i++) {
            // If character in s is found in t increment j
            if(j < s.length() && s.charAt(j) == t.charAt(i)) {
                j++;
            }
            // Check for subsequence
            if(j == s.length()) {
                break;
            }
        }
        return (j == s.length());
    }
    public static void main(String[] args) {
        String s = "agd";
        String t = "ahbgdc";
        Solution sol = new Solution();
        System.out.println("String s is a subsequence of String t: " + sol.isSubsequence(s, t));
    }
}