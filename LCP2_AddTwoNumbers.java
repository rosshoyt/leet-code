// leetcode problem #2 - Add Two Numbers
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
        ListNode out = new ListNode(), head = out;
        
        boolean cont = true;
        // Flags that represent if a list still has values to count
        boolean contl1 = true, contl2 = true;
        int carry = 0;      
        
        while(cont){
            out.val += carry;
            if(contl1 && l1 != null){
                out.val += l1.val;
                if(l1.next == null){
                    contl1 = false;        
                } else{
                    l1 = l1.next;
                }
            }
            if(contl2 && l2 != null){
                out.val += l2.val;
                
                if(l2.next == null){
                    contl2 = false;        
                } else{
                    l2 = l2.next;
                }
            }

            carry = out.val / 10;
            out.val -= carry * 10;
            
            cont = contl1 || contl2 || carry > 0;
            if(cont){
                out.next = new ListNode();
                out = out.next;
            }   
        }
        return head;
    }
}