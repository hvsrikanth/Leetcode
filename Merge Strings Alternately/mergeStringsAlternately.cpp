#include <string>
#include <iostream>
using namespace std;

class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        // Get the length of the two input strings
        int len1 = word1.length();
        int len2 = word2.length();
        string result = "";
        // Now loop thru' the strings and create the result
        for(int i = 0; i < max(len1, len2); i++) {
            // Get element from word1 to append
            if(i < len1) {
                result.push_back(word1[i]);
            }
            // Get element from word2 to append
            if(i < len2) {
                result.push_back(word2[i]);
            }
        }
        return result;
    }
};

int main() {
    Solution sol;
    string word1 = "microsoft";
    string word2 = "azure";
    cout << "Merged word is: " << sol.mergeAlternately(word1, word2) << endl;
    return 0;
}