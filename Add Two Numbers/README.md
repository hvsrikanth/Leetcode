# 2. Add Two Numbers - Leetcode Problem
Difficulty - *Medium*  
[Leetcode Link - Add Two Number](https://leetcode.com/problems/add-two-numbers/)
## Description
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.  
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:  
Input:  
List1 = 2 -> 4 -> 3 -> NULL  
List2 = 5 -> 6 -> 4 -> NULL  
Output:  
List3 = 7 -> 0 -> 8 -> NULL  

Explanation: 342 + 465 = 807

## Constraints:
* The number of nodes in each linked list is in the range [1, 100]
* 0 <= node->val <= 9
* It is guaranteed that the list represents a number that does not have leading zeros

## Solution
* Start traversing both singly linked lists (**L1, L2**) node by node
* At each node of L1 and L2, add the values from the corresponding nodes of L1 and L2, along with any **Carry** from the previous addition
* Sum = L1 Node -> val + L2 Node -> val + Carry
* If the sum exceeds 9, compute a carry for the next iteration as **Sum / 10** (Carry = Sum / 10)
* Set the value for the output node as **SUM % 10** (Output Node -> val  = Sum % 10)
* A new node is created for each sum and linked to the resulting Output node

## Key Points
* **Dummy Head:** Output linked list **List3** starts with a dummy node with value 0. This helps simplify the list creation logic. The actual result begins from **List3->next**
* **Handling Carry:** After processing all nodes in L1 and L2, the loop continues if there's any carry left
* **Edge Cases:** Solution handles cases where one list is longer than the other by setting node values to 0 for missing nodes. It also accounts for the carry that might need to be appended after traversing both lists

## Time Complexity
* **O(n):** Solution traverses the singly linked lists L1 and L2 until the end. So the time complexity is max (len(L1), len(L2))

## Space Complexity
* **O(n):** Solution creates a new linked list (L3) with a node for each digit in the result. In the worst case, the len(L3) is one more than max(len(L1), len(L2))

## Dry Run
List1 = 2 -> 4 -> 3 -> NULL  
List2 = 5 -> 6 -> 4 -> NULL  
Output:  
List3 = 7 -> 0 -> 8 -> NULL  

*Initial Carry is set to 0*

| Iteration   | L1 Node  | L2 Node  | Sum             | Carry       | L3 Node     |
| ----------- | -------- | -------- | --------------- | ----------- | ----------- |
| 1           | 2        | 5        | 2 + 5 + 0 = 7   | 7 / 10 = 0  | 7 % 10 = 7  |
| 2           | 4        | 6        | 4 + 6 + 0 = 10  | 10 / 10 = 1 | 10 % 10 = 0 |
| 3           | 3        | 4        | 3 + 4 + 1 = 8   | 8 / 10 = 0  | 8 % 10 = 8  |

[C++ Implementation](./addTwoNumbers.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go implementations will be added shortly.*