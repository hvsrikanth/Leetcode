#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int size = nums.size();
        // Initialize the answer array with 1
        vector<int> answer(size, 1);
        // Find left product and store in answer array
        // For i = 0, left product is 1
        int left = 1;
        for (int i = 0; i < size; i++) {
            answer[i] = left;
            left *= nums[i];
        }
        // Find right product and update answer array
        // For i = size-1, right product is 1
        int right = 1;
        for (int i = size - 1; i >= 0; i--) {
            // answer[i] holds left product.
            // Now multiplied with right product
            cout << "right: " << right << " ans: " << answer[i] << "  nums: " << nums[i] << endl;
            answer[i] *= right;
            right *= nums[i];
        }
        return answer;
    }
};

void printArray(const vector<int> &A) {
    for(auto x : A) {
        cout << x << " ";
    }
    cout << endl;
}

int main(void) {
    vector<int> nums1 = {1, 2, 3, 4};
    vector<int> nums2 = {-1, 1, 0, -3, 3};
    Solution sol;

    vector<int> answer1 = sol.productExceptSelf(nums1);
    vector<int> answer2 = sol.productExceptSelf(nums2);
    printArray(answer1);
    printArray(answer2);
    return 0;
}