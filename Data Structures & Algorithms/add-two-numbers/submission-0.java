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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1,l2,0);
    }
    public ListNode add(ListNode l1,ListNode l2,int c){
        if(l1==null && l2==null && c==0)return null;
        int a=0,b=0;
        if(l1!=null)a=l1.val;
        if(l2!=null)b=l2.val;
        int s=a+b+c;
        ListNode cur=new ListNode(s%10);
        if(l1!=null)l1=l1.next;
        if(l2!=null)l2=l2.next;
        ListNode l1next=l1;
        ListNode l2next=l2;
        cur.next=add(l1next,l2next,s/10);
        return cur;
    }
}
