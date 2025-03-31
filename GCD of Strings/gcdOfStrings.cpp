#include <iostream>
#include <string>
#include <numeric>
using namespace std;

class Solution {
    public:
        string gcdOfStrings(string str1, string str2) {
            string result = "";
            // Check if both strings are same when concatenated
            // with each other
            if(str1 + str2 == str2 + str1) {
                // GCD of lengths of str1 and str2 will give the
                // length of the string pattern repeated in both strings
                int gcdLen = gcd(str1.length(), str2.length());
                result = str1.substr(0, gcdLen);
            }
            return result;
        }
    };

    int main(){
        Solution sol;
        string s2 = "ABABAB";
        string s1 = "ABAB";
        cout << "GCD of strings is: " << sol.gcdOfStrings(s1, s2) << endl;
        return 0;
    }