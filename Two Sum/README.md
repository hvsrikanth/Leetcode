# 1. Two Sum - Leetcode Problem
Difficulty - *Easy*  
[Leetcode Link: Two Sum](https://leetcode.com/problems/two-sum/description/)
## Description
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.

### Example 1:
Input: nums = [2, 7, 11, 15], target = 13  
Output: [0, 2]  
Explanation: Because nums[0] + nums[2] == 13, we return [0, 2].  

## Constraints:
2 <= nums.length <= 104  
-109 <= nums[i] <= 109  
-109 <= target <= 109  
Only one valid answer exists.  

## Solution
The bruteforce solution is of time complexity **O(n<sup>2</sup>)** and hence ignored  
Input Array has elements {x<sub>1</sub>, x<sub>2</sub>, ..., x<sub>i</sub>, ..., x<sub>j</sub>, ..., x<sub>104</sub>}  
Given a target T, there exist two elements in the input array x<sub>i</sub>, x<sub>j</sub> such that x<sub>i</sub> + x<sub>j</sub> = T .i.e., x<sub>i</sub>, x<sub>j</sub> are complement of each other w.r.t. target T  
To achieve time complexity of **O(n)**, we use a data structure called hash map.  
* Initialize an empty hash map
* Iterate through the input array nums
    * For each element x<sub>i</sub>, we lookup the hash map for the its complement (x<sub>j</sub> = T - x<sub>i</sub>)
    * If it exists, return the current index (i) and index (j) stored in the hash map as (i, j)
    * If not, store the current array element (x<sub>i</sub>) as key and current index i as value

## Time Complexity:
* **O(n):** Time complexity is proportional to the size of the array, n. Hash map has an average time complexity of O(1), so each operation inside the for loop takes constant time
## Space Complexity:
* **O(n):** Space complexity is proportional to the size of the array, n, because in the worst case one  might store all n elements and their indices in the hash map

## Dry Run

Input: nums = [2, 7, 11, 15], target = 13  
Output: [0, 2]  

| Iteration   | x<sub>i</sub>  | x<sub>j</sub>  | HashMap (x<sub>j</sub> : i) |
| ----------- | -------------- | -------------- | --------------------------- |
| i = 0       | 2              | 13 - 2 = 11    | Empty, Store (2 : 0)       |
| i = 1       | 7              | 13 - 7 = 6     | 6 Not Found; Store (7 : 1)  |
| i = 2       | 11             | 13 - 11 = 2    | 2 Found; Return [0, 2]     |

## Source Code
[C++ Implementation](./twosum.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*