#include <string>
#include <iostream>
using namespace std;

class Solution {
public:
    bool isSubsequence(string s, string t) {
        // Two pointers i and j
        // j to iterate s
        int j = 0;
        // Iterate over the longer string t to check for 
        // presence of characters from smaller string s
        for (int i = 0; i < t.length(); i++) {
            // If character in s is found in t increment j
            if(j < s.length() && s[j] == t[i]) {
                j++;
            }
            // Check for subsequence
            if(j == s.length()) {
                break;
            }
        }
        return (j == s.length());
    }
};

int main(void) {
    string s = "agd";
    string t = "ahbgdc";
    Solution sol;
    cout << "string s is a subsequence of string t: " << sol.isSubsequence(s, t) << endl;
    return 0;
}