# 1679. Max Number of K-Sum Pairs - Leetcode Problem  

*Difficulty - Medium*  

[Leetcode Link - Max Number of K-Sum Pairs](https://leetcode.com/problems/max-number-of-k-sum-pairs/description)  

## Description
You are given an integer array `nums` and an integer `k`. In one operation, you can pick two numbers from the array whose sum equals `k` and remove them from the array. Return the *maximum number of operations you can perform on the array*.

## Example 1:
Input: `nums = [1,2,3,4], k = 5`  
Output: `2`  
Explanation: Starting with `nums = [1,2,3,4]`:
    - Remove numbers `1` and `4`, then `nums = [2,3]`  
    - Remove numbers `2` and `3`, then `nums = []`  
There are no more pairs that sum up to `5`, hence a total of `2` operations.

## Example 2:
Input: `nums = [3,1,3,4,3], k = 6`  
Output: `1`  
Explanation: Starting with `nums = [3,1,3,4,3]`:  
    - Remove the first two `3`'s, then `nums = [1,4,3]`  
There are no more pairs that sum up to `6`, hence a total of `1` operation.

## Constraints:
* `1 <= nums.length <= 10`<sup>`5`</sup>  
* `1 <= nums[i] <= 10`<sup>`9`</sup>
* `1 <= k <= 10`<sup>`9`</sup>

## Solution (Hashmap):
This solution is based on Hashmap. Below is the outline of the solution.
* Initialize `count` to `0`.
* Hashmap, key is the `element` of `nums` and the stored value is the frequency of it.
* For each `element` in the input array `nums`,
    * Get the `complement` of the `element` which is (`k - element`).
    * Look for this `complement` in the `hashmap`.
    * If found:
        * Increment the `count`
        * Decrement the frequency of the element by 1 (as we are looking pairs)
    * If not:
        * Store the `element` in `hashmap` and increment it's frequency by 1.
* Return `count`.

## Solution (Two Pointer):
This solution is based on Two Pointers. Below is the outline of the solution.
* Initialize `count` to `0`.
* Sort the input array in ascending order.
* Two pointers:
    * `left`: Moves from left to right (starts with `left = 0`)
    * `right`: Moves from right to left (starts with `right = size of nums - 1`)
* Iterate over the `nums` array, until `left` meets `right`
    * if `nums[left] + nums[right] == k`, we have our pair.
        * Increment `count`
        * Move `left` and `right` (`left++, right--`)
    * if `nums[left] + nums[right] < k`, move only `left` (`left++`)
    * if `nums[left] + nums[right] > k`, move only `right` (`right--`)
* Return `count`

## Time Complexity:
* **O(n) (Hashmap):** Time complexity is proportional to size of the input array.
* **O(nlogn) (Two Pointer):** Modifying the input array by sorting it is of **nlogn** complexity.

## Space Complexity:
* **O(n) (Hashmap):** Space for Hashmap is used and can be of size n in the worst case scenario.
* **O(1) (Two Pointer):** Constant space is used in the form of variables in the two pointer approach. Input array is modified.

## Note:
Both solutions achieve the goal. If one needs, better **time** go for hashmap based solution. If one needs, better **memory**, go for Two Pointer based solution.

## Dry Run (Hashmap):
Input: `nums = [3,1,3,4,3], k = 6`  
Variables: `count = 0, hashmap(int, int)`  

| i | nums[i] | k - nums[i] | complement in hashmap | count |   hashmap           |
| - | ------- | ----------- | --------------------- | ----- | ------------------- |
| 0 | 3       | 6 - 3 = 3   | No (3 is not found)   | 0     | (3:1)               |
| 1 | 1       | 6 - 1 = 5   | No (5 is not found)   | 0     | (3:1), (1:1)        |
| 2 | 3       | 6 - 3 = 3   | Yes (3 is found)      | 1     | (1:1)               |
| 3 | 4       | 6 - 4 = 2   | No (2 is not found)   | 1     | (1:1), (4:1)        |
| 4 | 3       | 6 - 3 = 3   | No (3 is not found)   | 1     | (1:1), (4:1), (3:1) |

Output: Return count = 1

## Dry Run (Two Pointer):
Input: `nums = [3,1,3,4,3], k = 6`  
Variables: `count = 0, left = 0, right = 4`

Sort the input array `nums`. `nums = [1,3,3,3,4]`

| left | nums[left] | right | nums[right] | nums[left] + nums[right] | Equal to k | count | Action              |
| ---- | ---------- | ----- | ----------- | ------------------------ | ---------- | ----- | ------------------- |
| 0    | 1          | 4     | 4           | 1 + 4 = 5                | No. 5 < 6  | 0     | left = 1            |
| 1    | 3          | 4     | 4           | 3 + 4 = 7                | No. 7 > 6  | 0     | right = 3           |
| 1    | 3          | 3     | 3           | 3 + 3 = 6                | Yes. 6 = 6 | 1     | left = 2, right = 2 |

Output: Return count = 1

## Source Code
[C++ Implementation](./maxOperations.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*