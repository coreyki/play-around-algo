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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return lists.length == 0 ? 
            null : mergeListDivide(lists, 0, lists.length-1);
    }
    
    private ListNode mergeListDivide(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        } else if (left + 1 == right) {
            return mergeTwoLists(lists[left], lists[right]);
        } else {
            int mid = left + (right - left) / 2;
            ListNode mergedLeft = mergeListDivide(lists, left, mid);
            ListNode mergedRight = mergeListDivide(lists, mid + 1, right);
            return mergeTwoLists(mergedLeft, mergedRight);
        }
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 != null ? l1 : l2;
        return head.next;
    }
    
    //Time: O(n) to merge two list with total n nodes
    //      O(logk) to go through merge process
    //      TotalO(Nlogk)
    //Space: O(1)
}
