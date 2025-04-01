#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        vector<bool> result(candies.size(), false);
        int maxCandies = INT32_MIN;
        // Find maximum candies in the candies vector
        for(int x : candies) {
            maxCandies = max(maxCandies, x);
        }
        // Now set the greatest vector with true or false
        // when extra candies are given to a kid at ith position
        for(int i = 0; i < candies.size(); i++) {
            if(candies[i] + extraCandies >= maxCandies) {
                result[i] = true;
            }
        }
        return result;
    }
};

int main(void) {
    vector<int> candies = {2,3,5,1,3};
    int extraCandies = 3;
    Solution sol;
    vector<bool> result = sol.kidsWithCandies(candies, extraCandies);
    for(auto x : result) {
        cout << x << " ";
    }
}