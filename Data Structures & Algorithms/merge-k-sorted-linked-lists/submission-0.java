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
    ListNode merger(ListNode one, ListNode two)
    {
        ListNode dummy=new ListNode(-1);
        ListNode three=dummy;
        while(one!=null && two!=null)
        {
            if(one.val<=two.val)
            {
                three.next=one;
                three=three.next;
                one=one.next;

            }
            else
            {
                three.next=two;
                three=three.next;
                two=two.next;
            }
        }
        three.next= (one!=null) ? one : two;
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int interval=1;
        int k=lists.length;
        if(k==0)
        {
            return merger(null,null);
        }
        while(interval<k)
        {
            for (int i = 0; i + interval < k; i += 2 * interval) {
    lists[i] = merger(lists[i], lists[i + interval]);
}
            interval*=2;
        } 
        return lists[0];   
        
    }
}
