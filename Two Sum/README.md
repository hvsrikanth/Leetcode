# Two Sum - Leetcode Problem
[Leetcode Link: Two Sum](https://leetcode.com/problems/two-sum/description/)
## Description  
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.

### Example 1:
Input: nums = [2, 7, 11, 15], target = 13  
Output: [0, 2]  
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].  

### Constraints:
2 <= nums.length <= 104  
-109 <= nums[i] <= 109  
-109 <= target <= 109  
Only one valid answer exists.  

## Solution
Let's ignore the bruteforce solution which is of time complexity O(n<sup>2</sup>)  
Input Array has elements {x<sub>1</sub>, x<sub>2</sub>, ..., x<sub>i</sub>, ..., x<sub>j</sub>, ..., x<sub>104</sub>}  
Given a target T, there exist two elements  in the input array x<sub>i</sub>, x<sub>j</sub> such that x<sub>i</sub> + x<sub>j</sub> = T  
To achieve time complexity of O(n), we use a data structure called HashMap.  
> In the HashMap, we store the compliment of current array element (x<sub>j</sub> = T - x<sub>i</sub>) as key and current index i as value.
> For every x<sub>i</sub>, we lookup the HashMap for the current element.
>> If it exists, return the two indices (i, j).  
>> If it does not exist, store the compliment of current element (x<sub>j</sub> = T - x<sub>i</sub>) and i in the HashMap.

## Dry Run

Input: nums = [2, 7, 11, 15], target = 13  
Output: [0, 2]  

| Iteration   | x<sub>i</sub>  | x<sub>j</sub>  | HashMap (x<sub>j</sub> : i) |
| ----------- | -------------- | -------------- | --------------------------- |
| i = 0       | 2              | 13 - 2 = 11    | Empty, Store (11 : 0)       |
| i = 1       | 7              | 13 - 7 = 6     | 7 Not Found; Store (6 : 1)  |
| i = 2       | 11             | 13 - 11 = 2    | 11 Found; Return [0, 2]     |

## Source Code
[C++ Implementation](./twosum.cpp)  
[Java Implementation](./Solution.java)

Javascript and Go will be added shortly.