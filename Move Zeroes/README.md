# 283. Move Zeroes - Leetcode Problem  

*Difficulty - Easy*  

[Leetcode Link - Move Zeroes](https://leetcode.com/problems/move-zeroes/description/)  

## Description
Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements. Note that you must do this in-place without making a copy of the array.

## Example 1:
Input: nums = [0,1,0,3,12]  
Output: [1,3,12,0,0]

## Example 2:
Input: nums = [0]  
Output: [0]

## Constraints:
1 <= nums.length <= 10<sup>4</sup>  
-2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1


## Solution
We use two-pointer approach for our solution.
* Two pointers `left` and `right`.
    * `left` tracks the 0's
    * `right` iterates over the array and looks for non-zero elements to be moved
* Efficient handling of zeros.
    * We swap only when `nums[right]` is non-zero and `nums[left]` is zero.
* Increment `left`.

## Time Complexity:
* **O(n):** Time complexity is proportional to the size of the array. Hence, linear complexity.
## Space Complexity:
* **O(1):** Constant space is used in terms of few variables. Input array is modified in memory and returned.

## Dry Run

Input: nums = [0,1,0,3,12]
Variables: left = 0, right = 0
| right | left | nums[right]  | nums[left]  | Action           | nums         |
| ----- | ---- | -----------  | ----------  | ---------------- | ------------ |
| 0     | 0    | nums[0] = 0  | nums[0] = 0 | -                | [0,1,0,3,12] |
| 1     | 0    | nums[1] = 1  | nums[0] = 0 | Swap, left = 1   | [1,0,0,3,12] |
| 2     | 1    | nums[2] = 0  | nums[1] = 0 | -                | [1,0,0,3,12] |
| 3     | 1    | nums[3] = 3  | nums[1] = 0 | Swap, left = 2   | [1,3,0,0,12] |
| 4     | 2    | nums[4] = 12 | nums[2] = 0 | Swap, left = 3   | [1,3,12,0,0] |

Output: nums = [1,3,12,0,0]

## Source Code
[C++ Implementation](./moveZeroes.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*