#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    // Method to check for vowel
    bool isVowel(const char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    int maxVowels(string s, int k) {
        int sLen = s.length();
        int count = 0;
        int maxCount = 0;
        // Find vowels count in the initial sliding window
        for(int i = 0; i < k; i++) {
            if(isVowel(s[i])) {
                count++;
            }
        }
        // Initialize maxCount
        maxCount = count;
        // Now get the vowels count for each subsequent window
        for(int i = 0; i < sLen-k; i++) {
            // Remove the first element count from previous sliding window
            if(isVowel(s[i])) {
                count--;
            }
            // Include the last element count of current sliding window
            if(isVowel(s[i+k])) {
                count++;
            }
            maxCount = max(maxCount, count);
        }
        // Return maximum count of vowels
        return maxCount;
    }
};

int main(void) {
    string s = "abciiidef";
    int k = 3;
    Solution sol;
    cout << "Max No of Vowels in substring length " << k << " is: " << sol.maxVowels(s, k) << endl;
    return 0;
}