package com.acm.lico.offer68;

class ListNode {
    int val;
    ListNode next = null;
  }
 

public class Solution22 {
    /**
     *  合并两个有序的单链表
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */
    public ListNode mergeTwoSortedList (ListNode head1, ListNode head2) {
        // write code here
        if(head1 == null) 
            return head2;
        if(head2 == null) 
            return head1;
        
        ListNode node1 = head1;
        ListNode node2 = head2;
        ListNode head,pre;
        if(head1.val < head2.val) {
           pre = head = head1;
            node1 = node1.next;
        } else{
           pre = head = head2;
            node2 = node2.next;
        }
        while( node1 != null || node2 != null) {
              if(node1 == null) {
                  pre.next = node2;
                  return head;
              } else if(node2 == null) {
                  pre.next = node1;
                  return head;
              } else if( node1.val < node2.val  ) {
                  pre.next = node1;
                  node1 = node1.next;
              } else{
                  pre.next = node2;
                  node2 = node2.next;
              }
             pre = pre.next;
            
        }
        return head;
    }
    

    
    
}