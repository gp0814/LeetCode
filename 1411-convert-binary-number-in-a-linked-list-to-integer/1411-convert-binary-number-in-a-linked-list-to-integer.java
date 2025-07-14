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
    public int getDecimalValue(ListNode head) {

        int res = 0;
        ListNode curr = head;

        while(curr != null){
            int val = curr.val;
            res = 2*res + val;
            curr = curr.next;
        }
        return res;
        
    }
}