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
       ListNode dummy=new ListNode(-1);
       ListNode cur=dummy;
       PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->a.val-b.val);
       for(ListNode x:lists){
        if(x==null)continue;
        pq.offer(x);
       }

    
       while(!pq.isEmpty()){
        ListNode a=pq.poll();
         cur.next=a;
         cur=cur.next;
         if(a.next!=null)
         pq.offer(a.next);
       }
       return dummy.next;

    }
}
