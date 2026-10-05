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
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        
        while(fast!=null && fast.next!=null){
           
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second=slow.next;
        slow.next=null;
        second = reverse(second);
        ListNode first=head;
        while(second!=null){
            ListNode secondnext=second.next;
            ListNode firstnext=first.next;
            first.next=second;
            second.next=firstnext;
            first=firstnext;
            second=secondnext;
        }



    }
    public ListNode reverse(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode newhead=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newhead;
    }
}
