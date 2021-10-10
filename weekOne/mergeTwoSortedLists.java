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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        ListNode rp = ret;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                rp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                rp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            rp = rp.next;
        }
        rp.next = l1 == null ? l2 : l1;
        return ret.next;
    }
}
