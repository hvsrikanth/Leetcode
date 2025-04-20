class Solution {
    // Method to check for vowel
    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public int maxVowels(String s, int k) {
        int sLen = s.length();
        int count = 0;
        int maxCount = 0;
        // Find vowels count in the initial sliding window
        for(int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i))) {
                count++;
            }
        }
        // Initialize maxCount
        maxCount = count;
        // Now get the vowels count for each subsequent window
        for(int i = 0; i < sLen-k; i++) {
            // Remove the first element count from previous sliding window
            if(isVowel(s.charAt(i))) {
                count--;
            }
            // Include the last element count of current sliding window
            if(isVowel(s.charAt(i+k))) {
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }
        // Return maximum count of vowels
        return maxCount;
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        Solution sol = new Solution();
        System.out.println("Max No of Vowels in substring length " + k + " is: " + sol.maxVowels(s, k));
    }
}