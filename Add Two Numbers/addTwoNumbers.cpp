#include <iostream>
#include <vector>
using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

void printList(ListNode* head){
    // Loop thru' the list and print value of each node
    ListNode* current = head;
    while(current != nullptr) {
        cout << current->val << " -> ";
        current = current->next;
    }
    cout << "nullptr" << endl;
}

ListNode* makeListNode(vector<int> A){
    ListNode* head = nullptr;
    if(!A.empty()) {
        // Create the head of the linked list
        head = new ListNode(A[0]);
        ListNode* current = head;

        // Iterate over the vector and create subsequent nodes
        for (int i = 1; i < A.size(); i++) {
            current->next = new ListNode(A[i]);
            current = current->next;
        }
    }
    return head;
}

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *tempA = l1;
        ListNode *tempB = l2;
        ListNode *C = new ListNode(0);
        ListNode *current = C;
        int carry = 0;
        // Variables to help with addition at each node traversal
        int x, y, sum;
        // Traverse the two singly linked lists until the end of each list
        // or until a carry exists
        while (tempA != nullptr || tempB != nullptr || carry != 0){
            x = tempA ? tempA->val : 0;
            y = tempB ? tempB->val : 0;
            // Add the numbers at each node and the carry
            sum = carry + x + y;
            carry = sum / 10;
            current->next = new ListNode(sum % 10);
            current = current->next;
            tempA = tempA ? tempA->next : nullptr;
            tempB = tempB ? tempB->next : nullptr;
        }
        return C->next;
    }
};

int main(void) {
    ListNode* list1 = makeListNode({9, 9, 9, 9, 9, 9, 9});
    ListNode* list2 = makeListNode({9, 9, 9, 9});
    printList(list1);
    printList(list2);
    Solution* sol = new Solution();
    ListNode* output = sol->addTwoNumbers(list1, list2);
    printList(output);
    return 0;
}