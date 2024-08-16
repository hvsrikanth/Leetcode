// Definition for singly-linked list.
class ListNode {
    int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {    
    // Method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Method to create a linked list from an array of integers
    public static ListNode makeListNode(int[] arr) {
        ListNode head = null;
        if (arr.length > 0) {
            head = new ListNode(arr[0]);
            ListNode current = head;
            for (int i = 1; i < arr.length; i++) {
                current.next = new ListNode(arr[i]);
                current = current.next;
            }
        }
        return head;
    }

    // Method to add two numbers represented as linked lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempA = l1;
        ListNode tempB = l2;
        ListNode C = new ListNode(0);
        ListNode current = C;
        int carry = 0;
        int x, y, sum;
        
        // Traverse the two linked lists
        while (tempA != null || tempB != null || carry != 0) {
            x = (tempA != null) ? tempA.val : 0;
            y = (tempB != null) ? tempB.val : 0;
            sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            tempA = (tempA != null) ? tempA.next : null;
            tempB = (tempB != null) ? tempB.next : null;
        }
        return C.next;
    }

    public static void main(String[] args) {
        // Create the input linked lists
        ListNode list1 = makeListNode(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode list2 = makeListNode(new int[]{9, 9, 9, 9});
        
        // Print the input linked lists
        printList(list1);
        printList(list2);
        
        // Create the Solution object and calculate the result
        Solution sol = new Solution();
        ListNode output = sol.addTwoNumbers(list1, list2);
        
        // Print the result linked list
        printList(output);
    }
}
