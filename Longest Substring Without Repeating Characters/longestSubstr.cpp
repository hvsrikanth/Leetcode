#include <iostream>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int lenS = s.length();
        unordered_map<char, int> charMap;
        int i = 0;
        int longest = 0;
        // Move the second pointer j to iterate thru' the end
        for (int j = 0; j < lenS; j++) {
            char c = s[j];
            charMap[c]++;
            // Adjust the window to ensure all characters are unique
            // Below while loop takes out duplicates and moves first pointer i
            // until there is no duplicate
            while (charMap[c] > 1) {
                char l = s[i];
                charMap[l]--;
                // Delete from map if count becomes 0
                if (charMap[l] == 0) {
                    charMap.erase(l);
                }
                // Move the left pointer to shrink the window
                i++;
            }
            // Compute longest based on the adjusted window
            longest = max(longest, j - i + 1);
        }
        return longest;
    };
};

int main () {
    string s = "abcabcbb";
    Solution *sol = new Solution();
    cout << "Input String: " << s << endl;
    cout << "Length of longest Substring Without Repeating Characters is: " << sol->lengthOfLongestSubstring(s) << endl;
}