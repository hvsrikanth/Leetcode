# 11. Container With Most Water - Leetcode Problem  

*Difficulty - Medium*  

[Leetcode Link - Container With Most Water](https://leetcode.com/problems/container-with-most-water/description/)  

## Description
You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `ith` line are `(i, 0)` and `(i, height[i])`. Find two lines that together with the x-axis form a container, such that the container contains the most water.  

Return the *maximum amount of water* a container can store.  

**Notice:** that you may not slant the container.

## Example 1:
Input: `height = [1,8,6,2,5,4,8,3,7]`  
Output: `49`  
Explanation: The above vertical lines are represented by array `[1,8,6,2,5,4,8,3,7]`. In this case, the max area of water (blue section) the container can contain is 49.

![Image](./question_11.jpg)

## Example 2:
Input: height = [1,1]  
Output: 1

## Constraints:
`n == height.length`  
`2 <= n <= 10`<sup>`5`</sup>  
`0 <= height[i] <= 10`<sup>`4`</sup>

## Solution
Please refer to the picture in Example 1 for visual illustration of the `height` array. As we move the boundaries of the container on the left and right, the blue area occupied by water. We need to find the boundaries on left and right, such that the blue area is maximized. We will use two pointer approach for the solution.
* Two pointers `left` and `right`; `left` defines the left boundary and `right` defines the right boundary.
* `height[left]` and `height[right]` point to the left and right side height of the container at `left` and `right` positions respectively.
* Iterate over the `height` array until `left` meets `right`.
    * Area is defined by `(right - left) * min(height[left], height[right])`.
    * If `height[left]` is less than `height[right]`, then we move `left` by `left++`.
    * Else we move `right` by `right--`.
* Return `max(area)` found

## Time Complexity:
* **O(n):** Time complexity is proportional to the size of the `height` array. Hence, linear time complexity.
## Space Complexity:
* **O(1):** Constant space is used in the form of pointer and area variables.

## Dry Run

Input: `height = [1,8,6,2,5,4,8,3,7]`  
Variables: `left = 0, right = 8`  
Size of `height = 9`  
Area: `(right - left) * min(height[left], height[right])`

| left | right | height[left]   | height[right] | Current Area   | Max Area | Action      |
| ---- | ----- | -------------- | ------------- | -------------- | -------- | ----------- |
| 0    | 8     | height[0] = 1  | height[8] = 7 | (8-0) * 1 = 8  | 8        | left++ = 1  |
| 1    | 8     | height[1] = 8  | height[8] = 7 | (8-1) * 7 = 49 | 49       | right-- = 7 |
| 1    | 7     | height[1] = 8  | height[7] = 3 | (7-1) * 3 = 18 | 49       | right-- = 6 |
| 1    | 6     | height[1] = 8  | height[6] = 8 | (6-1) * 8 = 40 | 49       | right-- = 5 |
| 1    | 5     | height[1] = 8  | height[5] = 4 | (5-1) * 4 = 16 | 49       | right-- = 4 |
| 1    | 4     | height[1] = 8  | height[4] = 5 | (4-1) * 5 = 15 | 49       | right-- = 3 |
| 1    | 3     | height[1] = 8  | height[3] = 2 | (3-1) * 2 = 4  | 49       | right-- = 2 |
| 1    | 2     | height[1] = 8  | height[2] = 6 | (2-1) * 6 = 6  | 49       | right-- = 1 |

Return maximum **`area = 49`**

## Source Code
[C++ Implementation](./maxArea.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*