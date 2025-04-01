# 1431. Kids with Greatest Number of Candies - Leetcode Problem

*Diffculty - Easy*  

[Leetcode Link - Kids with Greatest Number of Candies](https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/)

## Description
There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.  

Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.  

Note that **multiple** kids can have the **greatest** number of candies.

## Example 1:
Input: candies = [2,3,5,1,3], extraCandies = 3  
Output: [true,true,true,false,true]  
Explanation: If you give all extraCandies to:  
- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.

## Example 2:
Input: candies = [4,2,1,1,2], extraCandies = 1  
Output: [true,false,false,false,false]  
Explanation: There is only 1 extra candy. Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.

## Example 3:
Input: candies = [12,1,12], extraCandies = 10  
Output: [true,false,true]

## Constraints:
n == candies.length  
2 <= n <= 100  
1 <= candies[i] <= 100  
1 <= extraCandies <= 50  

## Solution:
To find if a kid will have maximum candies when given extra candies, one needs to know the max number of candies and then compare the extra candies + candies with the kid with max number of candies.
* Initiate a result array
* Iterate thru the input candies array and set maxCandies.
* Iterate once more thru the input candies array and set result array to true if candies[i] + extraCandies >= maxCandies else set to false.

## Time Complexity:
**O(n):** Iterate thru the array to find max. Iterate once more thru the array to set the result.

## Space Complexity:
**O(1)**: Using constant space only in the form of variables. Ignoring the input and return parameters for the solution.

## Dry Run
Input: candies = [2,3,5,1,3], extraCandies = 3  
Output: result 
Variable: maxCandies = 0

| i | candies[i] | max(maxCandies, candies[i]) |
| - | ---------- | --------------------------- |
| 0 |  2         | max(0, 2) = 2               |
| 1 |  3         | max(2, 3) = 3               |
| 2 |  5         | max(3, 5) = 5               |
| 3 |  1         | max(5, 1) = 5               |
| 4 |  3         | max(5, 3) = 5               |

maxCandies = 5

| i | candies[i] | candies[i] + extraCandies > maxCandies | result[i] |
| - | ---------- | -------------------------------------- | --------- |
| 0 |  2         | 2 + 3 > 5 (true)                       | true      |
| 1 |  3         | 3 + 3 > 5 (true)                       | true      |
| 2 |  5         | 5 + 3 > 5 (true)                       | true      |
| 3 |  1         | 1 + 3 > 5 (false)                      | false     |
| 4 |  3         | 3 + 3 > 5 (true)                       | true      |

result = [true, true, true, false, true]

## Source Code
[C++ Implementation](./kidsWithCandies.cpp)
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*