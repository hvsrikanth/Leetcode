#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

void printArray(const vector<int> &A){
    if(!A.empty()) {
        cout << "[" << A[0] << ", " << A[1] << "]" << endl;
    } else {
        cout << "[" << " ]" << endl;
    }
}

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        // Size of the input vector
        int size = nums.size();
        // Unordered Map to store the compliment of current element w.r.t target
        unordered_map<int, int> unordmap;
        // Vector to store the indices of the two elements of input vector adding up to target
        vector<int> result;
        // Traverse the input vector and check if the complement element is in the Unordered Map
        // If it exists then we found the elements adding to target
        // Else store the current element in the Unordered Map
        for(int i = 0; i < size; i++){
            if(unordmap.find(target - nums[i]) == unordmap.end()){
                unordmap[nums[i]] = i;
            }else{
                result.push_back(unordmap[target - nums[i]]);
                result.push_back(i);
                break;
            }
        }
        return result;
    }
};

int main(){
    vector<int> A = {1, 10, 8, 7, 11, 19, 2, 5, 9, 12};
    int target = 22;
    Solution *sol = new Solution();
    vector<int> result = sol->twoSum(A, target);
    printArray(result);
    return 0;
}