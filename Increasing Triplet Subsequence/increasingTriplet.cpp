#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        int size = nums.size();
        bool tripletExists = false;
        // Iterate thru' the array to find smaller left and a greater right
        // We start with i = 1 as we need to check left of 1 which is 0
        for (int i = 1; i < size-1; i++) {
            // Indicates smaller left is found
            bool left = false;
            // Indicates greater right is found
            bool right = false;
            // Find smaller left
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    left = true;
                    break;
                }
            }
            // Find greater right
            for (int k = i+1; k < size; k++) {
                if (nums[k] > nums[i]) {
                    right = true;
                    break;
                }
            }
            // Both left and right found we have our triplet
            if(left && right) {
                tripletExists = true;
                break;
            }
        }
        return tripletExists;
    }
};

int main(void) {
    vector<int> nums = {2,1,5,0,4,6};
    Solution sol;
    cout << "Increasing triplet subsequence exists: " << sol.increasingTriplet(nums) << endl;
    return 0;
}