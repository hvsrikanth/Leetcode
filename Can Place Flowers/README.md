# 605. Can Place Flowers - Leetcode Problem

*Difficulty - Easy*  

[Leetcode Link - Can Place Flowers](https://leetcode.com/problems/can-place-flowers/description/)  

## Description
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots. Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

## Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1  
Output: true  

## Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2  
Output: false  

## Constraints:
1 <= flowerbed.length <= 2 * 10<sup>4</sup>  
flowerbed[i] is 0 or 1.  
There are no two adjacent flowers in flowerbed.  
0 <= n <= flowerbed.length  

## Solution
Problems says that one cannot plan flowers in adjacent plots. So per this condition an plot needs to have left and right of it also free. Meaning, one needs to have 3 consecutive 0's in the flowerbed input array. Also, once we identify a free plot, mark it filled. So here is the outline of the solution.
* Iterate thru' the flowerbed array looking for a 0.
* If found, look for 0 to the left and to the right.
* If found, mark the plot as 1, reduce n by 1.
* Check if n == 0. If so exit the for loop.
* If n == 0 return true else return false.

I included a check on n being 0 as input. This was one of the test cases.

## Time Complexity
**O(n):** Iterate thru' the input flowerbed array to check for open plots.

## Space Complexity
**O(1):** Space for few primitive datatype variables is used and hence constant.

## Dry Run
Input: flowerbed = [1,0,0,0,1], n = 2  
Output: false  

| i | flowerbed[i] | flowerbed[i-1] | flowerbed[i+1] | n | flowerbed[i] |
| - | ------------ | -------------- | -------------- | - | ------------ |
| 0 |  1           | -              | 0              | 2 | 1            |
| 1 |  0           | 1              | 0              | 2 | 0            |
| 2 |  0           | 0              | 0              | 1 | 1 (Updated)  |
| 3 |  0           | 1              | 1              | 1 | 0            |
| 4 |  1           | 1              | -              | 1 | 1            |

At end of all iterations flowerbed = [1,0,1,0,1] and n is 1. There is only 1 possible open plot at i = 2.  
Hence return false.

## Source Code
[C++ Implementation](./canPlaceFlowers.cpp)  
[Java Implementation](./Solution.java)  

*Javascript and Go will be added shortly.*