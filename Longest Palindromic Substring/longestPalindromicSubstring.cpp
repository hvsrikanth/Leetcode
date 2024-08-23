#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    string getPalindrome(const int sLen, string s, int i, int j) {
        int left = i;
        int right = j;
        // Expand the palindrome from i and j using left and right pointers
        // Move left towards left and right towards right
        while (left >= 0 && right <= sLen - 1 && s[left] == s[right]) {
            left--;
            right++;
        }
        // Increment left pointer and Decrement right pointer to adjust their values
        // as they have changed before while loop failure
        // Return the palindrome
        return s.substr(left + 1, right - left - 1);
    }

    string longestPalindrome(string s) {
        const int sLen = s.length();
        string longest = "";
        if (sLen > 0) {
            longest = s.substr(0, 1);
            for (int i = 0; i < sLen - 1; i++) {
                // Odd length case
                string p1 = getPalindrome(sLen, s, i, i);
                if (p1.length() > longest.length()) {
                    longest = p1;
                }
                // Even length case
                string p2 = getPalindrome(sLen, s, i, i + 1);
                if (p2.length() > longest.length()) {
                    longest = p2;
                }
            }
        }
        return longest;
    }
};

int main(){
    string s = "zxcabebad";
    Solution sol;
    cout << "Longest palindromic substring in s: " << s << " is: " << sol.longestPalindrome(s) << endl;
    return 0;
}