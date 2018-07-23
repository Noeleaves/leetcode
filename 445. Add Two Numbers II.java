/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int len1 = 0;
        int len2 = 0;
        ArrayList<Integer> counts = new ArrayList<>();
        counts.add(0);
        int count = 0;
        ListNode head1 = l1, head2 = l2;
        
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                len1++;
                l1 = l1.next;
            }
            if(l2 != null) {
                len2++;
                l2 = l2.next;
            }
        }
        System.out.println(len1 +" : "+len2);
        
        int gap = Math.abs(len2 - len1);
        
        if(len1 < len2) {
            ListNode tmp = head1;
            head1 = head2;
            head2 = tmp;
        }
        ListNode tmp = new ListNode(0);
        ListNode curr = tmp;
        ListNode prev = null;
        for(int i = 0; i < Math.max(len1, len2); i++) {
            if(gap != 0) {
                gap--;
                tmp.next = new ListNode(head1.val);
                head1 = head1.next;
            }else {
                tmp.next = new ListNode(head1.val + head2.val);
                head1 = head1.next;
                head2 = head2.next;
            }
            tmp = tmp.next;
            curr.next = prev;
            prev = curr;
            // if(prev.next != null)System.out.println("prev:"+" "+prev.next.val);
            curr = tmp;
            // System.out.println("tmp:"+" "+tmp.val);
            // System.out.println("curr:"+" "+curr.val);
        }
        curr.next = prev;
        prev = null;
        while(tmp != null) {
            tmp.val += count;
            count = tmp.val/10;
            tmp.val = tmp.val%10;
            // System.out.println(tmp.val);
            tmp = tmp.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev.val == 0?prev.next:prev;
    }
}
