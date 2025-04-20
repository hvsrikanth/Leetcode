#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        // Two pointers left and right for expanding the window
        int left = 0;
        int right = 0;
        // Counter for 0's
        int count = 0;
        int maxLength = 0;
        // Loop thru' input array
        while(right < nums.size()) {
            // Current element is 0, count it
            if(nums[right] == 0) {
                count++;
            }
            // If 0's count exceeds 1 then shrink the window by moving left
            while(count > 1) {
                if(nums[left] == 0) {
                    // Reduce as we are leaving a 0 behind
                    count--;
                }
                left++;
            }
            // Update maxLength.
            // right-left does not have +1 to mimic removal of 0
            maxLength = max(maxLength, right-left);
            // Expand the window
            right++;
        }
        return maxLength;
    }
};

int main(void) {
    vector<int> nums = {0,1,1,1,0,1,1,0,1};
    Solution sol;
    cout << "Longest possible Subarray with 1's: " << sol.longestSubarray(nums) << endl;
    return 0;
}