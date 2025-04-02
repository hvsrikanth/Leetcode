class Solution {
    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
    public String reverseVowels(String s) {
        // Initialize left and right pointers
        int left = 0;
        int right = s.length()-1;
        // Convert String to a character array
        // As we need to swap the vowels
        char[] str = s.toCharArray();
        // Loop thru' the string and look for vowels from left and right
        while(left < right) {
            // If vowel is found at left and right pointers
            // swap the vowels and adjust pointers towards each other
            if(isVowel(str[left]) && isVowel(str[right])) {
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            }
            // Move left towards right until a vowel is found
            if(left < right && !isVowel(str[left])) {
                left++;
            }
            // Move right towards left until a vowel is found
            if(right > left && !isVowel(str[right])) {
                right--;
            }
        }
        return new String(str);
    }
    public static void main(String[] args) {
        String s = "IceCreAm";
        Solution sol = new Solution();
        System.out.println("Reversal of vowels in " + s + " is: " + sol.reverseVowels(s));
    }
}