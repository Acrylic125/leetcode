# https://leetcode.com/problems/add-two-numbers/
from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        sumL1 = 0
        e = 1 
        cur = l1
        while cur is not None:
            sumL1 += cur.val * e
            cur = cur.next
            e *= 10
        
        sumL2 = 0
        e = 1 
        cur = l2
        while cur is not None:
            sumL2 += cur.val * e
            cur = cur.next
            e *= 10
        
        acc = sumL1 + sumL2
        head = None
        result = None
        while True:
            rem = acc % 10
            acc = acc // 10
            
            if result is None:
                result = ListNode(rem, None)
            else:
                newNode = ListNode(rem, None)
                result.next = newNode
                result = newNode
            if head is None:
                head = result
            
            if acc == 0:
                break
        return head

a = ListNode(2, ListNode(4, ListNode(3, None)))
b = ListNode(5, ListNode(6, ListNode(4, None)))
ll = Solution().addTwoNumbers(a, b)
while ll is not None:
    print(ll.val)
    ll = ll.next
