/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        if(m == n) return head;
        ListNode ans = new ListNode(1);
        ListNode beforeM = ans;
        beforeM.next = head;
        ListNode current = head;
        ListNode After = head.next;
        
        for (int i = 1; i < m; i++) {
            beforeM = current;
            current = current.next;
            After = After.next;
        }
        
        ListNode before = beforeM;
//        beforeM = current;
        
        for (int j = m; j < n; j++) {
            current.next = before;
            before = current;
            current = After;
            After = After.next;
        }
        
        current.next = before;
        beforeM.next.next = After;
        beforeM.next = current;
        //beforeM.next = After;
        //beforeM = current;
        return ans.next;
    }
}
