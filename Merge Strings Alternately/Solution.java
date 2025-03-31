class Solution {
    public String mergeAlternately(String word1, String word2) {
        // Get the length of the two input strings
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder result = new StringBuilder();
        // Now loop thru' the strings and create the result
        for(int i = 0; i < Math.max(len1, len2); i++) {
            // Get element from word1 to append
            if(i < len1) {
                result.append(word1.charAt(i));
            }
            // Get element from word2 to append
            if(i < len2) {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String word1 = "microsoft";
        String word2 = "azure";
        System.out.println("Merged word is: " + sol.mergeAlternately(word1, word2));;    
    }
}