# 4. Median of Two Sorted Arrays - Leetcode Problem  
*Difficulty - Hard*  
[Leetcode Link - Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)  
## Description  
Given two sorted arrays A and B of size m and n respectively, return the median of the two sorted arrays.  
The overall run time complexity should be O(log (m+n)).  

**Example 1:**  
Input:  
* A = [ 2, 4, 6, 8, 10 ]  
* B = [ 3, 5, 7, 9, 11, 13, 15 ]  
* Output: 7.5

Explanation:  
* Merged array = [ 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15 ]  
* Merged array length = 12 (Even number)  
* Median is: (7 + 8) / 2 = 15 / 2 = 7.5 (sum of middle two elements / 2)  

**Example 2:**  
Input:  
* A = [ 2, 4, 6, 8, 10 ]  
* B = [ 3, 5, 7, 9, 11, 13 ]  
* Output: 7.0  

Explanation:  
* Merged array = [ 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13 ]  
* Merged array length = 11 (Odd number)  
* Median is: 7 (Middle element of the merged array)  

## Constraints:

A.length == m  
B.length == n  
0 <= m <= 1000  
0 <= n <= 1000  
1 <= m + n <= 2000  
-10<sup>6</sup> <= A[ i ], B[ i ] <= 10<sup>6</sup>  

## Solution
The problem requires finding the median of two sorted arrays with a time complexity of **O(log (m+n))**. This is a hint to use a binary search approach. The key idea is to partition the two arrays in such a way that the left halves contain the smaller elements and the right halves contain the larger elements, without merging the two sorted arrays.  
1. **Goal:** Divide the combined arrays A and B into two halves such that:
    * The total number of elements in the left half and right half are the same (or differ by 1 for odd-length arrays).
    * All elements in the left half are smaller than or equal to all elements in the right half.
2. **Binary Search on shorter array:** Perform binary search on the smaller array (A or B), as this ensures the binary search will have O(log(min(m, n))) complexity. Let A be the smaller array and B be the larger array.
3. **Partition the Arrays:** Partition the arrays into two halves: A[ 0...i-1 ] and B[ i...m-1 ] for the smaller array, and B[ 0...j-1 ] and B[ j...n-1 ] for the larger array. The index **i** is the partition index for array **A**, and **j** is the partition index for array **B**, where j is calculated as ((m + n + 1) / 2) - i.
4. **Check Valid Partition:** Ensure the partition is valid by checking:
* A[ i-1 ] <= B[ j ] (if i > 0)
* B[ j-1 ] <= A[ i ] (if j > 0)
* If the partition is valid, you have successfully divided the arrays into two halves such that all elements in the left half are smaller than those in the right half.
5. **Calculate the Median:**
* If the total number of elements (m + n) is odd, the median will be the maximum of the left side: max(A[ i-1 ], B[ j-1 ]).
* If the total number of elements (m + n) is even, the median will be the average of the maximum element on the left side and the minimum element on the right side: (max(A[ i-1 ], B[ j-1 ]) + min(A[ i ], B[ j ])) / 2.
6. **Adjust the Binary Search:** If the partition is not valid (i.e., A[ i-1 ] > B[ j ] or B[ j-1 ] > A[ i ]), adjust the binary search:
* If A[ i-1 ] > B[ j ], decrease i (move the partition to the left).
* If B[ j-1 ] > A[ i ], increase i (move the partition to the right).

## Time Complexity:
* **O(log(min(m, n))):** By using binary search, the problem size is reduced logarithmically to (O(log(min(m, n)))).

## Space Complexity:
* **O(1)**: Solution only uses a constant amount of extra space regardless of the input size. A few integer variables (i, j, maxLeftA, minRightA, maxLeftB, minRightB) to store indices and values during the binary search. No additional data structures like arrays or lists are used that would depend on the size of the input arrays.

## Dry Run
A = [ 2, 4, 6, 8, 10 ]  
B = [ 3, 5, 7, 9, 11, 13, 15 ]  
* Initial values of variables
    * Size of A: m = 5  
    * Size of B: n = 7  
    * low = 0, high = 5  
    * i = (low + high) / 2 = (0 + 5) / 2 = 2
    * j = ((m + n + 1) / 2) - i = ((5 + 7 + 1) / 2 ) - 2 = 6 - 2 = 4
    * maxLeftA = A[ i-1 ] = A[ 1 ] = 4
    * minRightA = A[ i ] = A[ 2 ] = 6
    * maxLeftB = B[ j - 1] = B[ 3 ] = 9
    * minRightB = B[ j ] = B[ 4 ] = 11

|  i  |  j  |  maxLeftA  |  minRightA  |  maxLeftB  |  minRightB  |   Partition Check      |     Binary Search Adjustment     |
| --- | --- | ---------- | ----------- | ---------- | ----------- | -------------------    | -------------------------------- |
|  2  |  4  |      4     |      6      |      9     |      11     | Fail: 9 is not < 6     | Adjust low to right = i + 1 = 3  |
|  4  |  2  |      8     |     10      |      5     |       7     | Fail: 8 is not < 7     | Adjust high to left = i - 1 = 3  |
|  3  |  3  |      6     |      8      |      7     |       9     | Pass: 6 <= 9 && 7 <= 8 | Median for even case found       |

Median = max(6, 7) + min(8, 9) / 2.0 = (7 + 8) / 2.0 =  15 / 2.0 = 7.5

[C++ Implementation](./medianSortedArrays.cpp)  
[Java Implementation](./Solution.java)  

*Javascript and Go implementations will be added shortly*