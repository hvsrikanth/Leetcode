# 238. Product of Array Except Self - Leetcode Problem  

*Difficulty - Medium*  

[Leetcode Link - Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description/)  

## Description
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i]. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.  
You must write an algorithm that runs in O(n) time and without using the division operation.

## Example 1:
Input: nums = [1,2,3,4]  
Output: [24,12,8,6]

## Example 2:
Input: nums = [-1,1,0,-3,3]  
Output: [0,0,9,0,0]

## Constraints:
2 <= nums.length <= 10<sup>5</sup>  
-30 <= nums[i] <= 30  
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.

## Solution
As division is not allowed, we need a different way to get to the product. We need to think of the product being made of 2 steps. For each array element nums[i], we need product of elements to left of nums[i] and then to the right of nums[i]. Finally the product of left and right to nums[i], will give the product without self. So for each nums[i]:
* Left product: Mulitply elements to left of nums[i]. 
* Right product: Muliply elements to right of nums[i]. 
* Answer: Multiply left and right products.
    * To efficiently manage the storage, we store the left product first in answer array.
    * When calculting right product, update the answer array to get the final product.

## Time Complexity:
* **O(n):** Time complexity is proportional to the size of the array, n. Hence linear complexity.
## Space Complexity:
* **O(1):** Constant space is used in terms of variables. Input and output is not considered for complexity calculation.

## Dry Run

Input: nums = [1,2,3,4]  
Variables: answer[1,1,1,1], left = 1  
Note: For i = 0, left = 1  

| i | left | nums[i] | answer[i] = left | left *= nums[i] |
| - | ---- | ------- | ---------------- | --------------- |
| 0 | 1    | 1       | 1                | 1 * 1 = 1       |
| 1 | 1    | 2       | 1                | 1 * 2 = 2       |
| 2 | 2    | 3       | 2                | 2 * 3 = 6       |
| 3 | 6    | 4       | 6                | 6 * 4 = 24      |

Variables: answer[1,1,2,6], right = 1  
Note: for i = 3, right = 1  

| i | right | nums[i] | answer[i] *= right | right *= nums[i] |
| - | ----- | ------- | ------------------ | ---------------  |
| 3 | 1     | 4       | 6 * 1 = 6          | 1 * 4 = 4        |
| 2 | 4     | 3       | 2 * 4 = 8          | 4 * 3 = 12       |
| 1 | 12    | 2       | 1 * 12 = 12        | 12 * 2 = 24      |
| 0 | 24    | 1       | 1 * 24 = 24        | 24 * 1 = 24      |

Final answer = [24,12,8,6]

## Source Code
[C++ Implementation](./productExceptSelf.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*