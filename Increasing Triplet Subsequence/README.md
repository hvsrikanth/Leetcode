# 334. Increasing Triplet Subsequence - Leetcode Problem  

*Difficulty - Medium*  

[Leetcode Link - Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/description/)  

## Description
Given an integer array nums, return **`true`** if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return **`false`**.

## Example 1:

Input: nums = [1,2,3,4,5]  
Output: true  
Explanation: Any triplet where i < j < k is valid.  

## Example 2:
Input: nums = [5,4,3,2,1]  
Output: false  
Explanation: No triplet exists.  

## Example 3:
Input: nums = [2,1,5,0,4,6]  
Output: true  
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.  

## Constraints:
1 <= nums.length <= 5 * 10<sup>5</sup>  
-2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1  

## Solution
*For my initial submission on Leetcode, I got Timelimit Exceeded error. This submission had O(n<sup>2</sup>) time complexity. For each nums[i], I was checking smaller left and greater right element. You may check version history, to see the code leading to this error. Below is the final solution details.*

Let's assume first, second and third are three elements in nums array. We to check if first < second < third and if so, we have our triplet.
* Let's have two variables first and second initialized to INT_MAX:
    * first is the smallest element found so far
    * second is the smallest element found larger than first
* For each element in nums array:
    * if current element is greater than second, we have our triplet. Return true.
    * if current is greater than first, then it is second.
    * else it is first.
* If there is no increasing triplet, return false.

## Time Complexity:
* **O(n):** Time complexity is proportional to the size of the array, n. Hence linear complexity.

## Space Complexity:
* **O(1):** Constant space is used in the form of few variables.

## Dry Run

Input: [2,1,5,0,4,6]
Variables: first = INT_MAX, second = INT_MAX, tripletExists = false  
X denotes current element

| X | X > second  | tripletExists | X > first   | second  | first |
| - | ----------  | ------------- | ----------- | ------- | ----- |
| 2 | 2 > INT_MAX | false         | 2 > INT_MAX | INT_MAX | 2     |
| 1 | 1 > INT_MAX | false         | 1 > 2       | INT_MAX | 1     |
| 5 | 5 > INT_MAX | false         | 5 > 1       | 5       | 1     |
| 0 | 0 > 5       | false         | 0 > 1       | 5       | 0     |
| 4 | 4 > 5       | false         | 4 > 0       | 4       | 0     |
| 6 | 6 > 4       | true          | -           | -       | -     |

Return tripetExists = true

## Source Code
[C++ Implementation](./increasingTriplet.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*