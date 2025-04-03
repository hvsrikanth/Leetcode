class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int end = n - 1;
        // Iterate thru' the string from the end
        while (end >= 0) {
            // Skip trailing spaces
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }
            if (end < 0) break;
            // Find the start of the word
            int start = end;
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }
            // Add the word to the result
            // If the result is already filled add a space
            // before adding the word
            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(s.substring(start + 1, end + 1));
            // Move to the next word
            end = start - 1;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String s = "the sky is blue";
        s = "  hello world  ";
        s = "a good   example";
        Solution sol = new Solution();
        System.out.println("Reverse worded string is: " + sol.reverseWords(s));
    }
}