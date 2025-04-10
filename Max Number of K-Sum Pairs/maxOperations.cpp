#include <vector>
#include <unordered_map>
#include <iostream>
using namespace std;

class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        unordered_map<int, int> map;
        int count = 0;
        // Loop thru' the nums array to check for k sum elements
        for (int i = 0; i < nums.size(); i++) {
            // Get the complement of current element
            int complement = k - nums[i];
            // Look for the complement of current element in the map
            if (map[complement] > 0) {
                // Found the pair, increment the count
                count++;
                // Reduce complement count as we are looking for pairs
                map[complement]--;
            } else {
                // Store the current element for possible pairing
                map[nums[i]]++;
            }
        }
        return count;
    }
};

int main(void) {
    vector<int> nums = {3,1,3,4,3};
    int k = 6;
    Solution sol;
    cout << "Number of Operations: " << sol.maxOperations(nums, k) << endl;
    return 0;
}