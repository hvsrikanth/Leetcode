#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        int size = nums.size();
        int sumK = 0;
        int maxSumK = 0;
        // Find the sum for the initial sliding window
        for(int i = 0; i < k; i++) {
            sumK += nums[i];
        }
        // Initialize maxSumK with sumK
        maxSumK = sumK;
        // Now calculate sum for each subsequent sliding window
        for(int i = 0; i < size-k; i++) {
            // Remove the first element from previous sliding window
            // Include the last element of current sliding window
            sumK += nums[i+k] - nums[i];
            maxSumK = max(maxSumK, sumK);
        }
        return (double)maxSumK / k;
    }
};

int main(void) {
    vector<int> nums = {1,12,-5,-6,50,3};
    int k = 4;
    Solution sol;
    cout << "Max Average of Subarray of size: " << k << " is: " << sol.findMaxAverage(nums, k) << endl;
    return 0;
 }