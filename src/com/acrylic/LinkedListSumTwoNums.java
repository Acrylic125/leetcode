package com.acrylic;

public class LinkedListSumTwoNums {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }

         public ListNode chain(int val) {
             next = new ListNode(val);
             return next;
         }

         @Override
         public String toString() {
             return "" + val + ((next != null) ? next.toString() : "");
         }
     }



    public static void main(String[] args) {
        ListNode l1 = create(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1);
        ListNode l2 = create(5,6,4);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode create(int... ints) {
        ListNode listNode = new ListNode(ints[0]);
        ListNode last = listNode;
        for (int i = 1; i < ints.length; i++)
            last = last.chain(ints[i]);
        return listNode;
    }

    public static long toReversedInt(ListNode listNode) {
         long i = 0, acc = 0;
         ListNode current = listNode;
         do {
             acc += (current.val * Math.pow(10, i));
             current = current.next;
             i++;
         } while (current != null);
         return acc;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
