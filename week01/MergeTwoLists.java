/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {     
        // 循环解法
        ListNode head = new ListNode();
        ListNode l3 = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        if (l1 == null) {
            l3.next = l2;
        } else {
            l3.next = l1;
        }
        return head.next;
        // 递归解法
        /*if (l1 == null) {
            return l2;
        } 
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);;
            return l2;
        }*/
    }
}