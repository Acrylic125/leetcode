# https://leetcode.com/problems/reverse-nodes-in-k-group/
from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head is None:
            return None
        i = 0 
        cur = head
        startOfGroup = None
        newHead = None
        prev = None
        while cur is not None:
            next = cur.next
            if next is None:
                break 
            if (i % k) == 0:
                startOfGroup = cur
            else:
                cur.next = prev
            i += 1
            cur = next
        remainder = i % k
        # newHead = None
        # groupStart = None
        # groupCur = head        
        # prev = None
        # while True:
        #     if i == 0:
        #         pass
        #     i = (i + 1) % k
        #     next = groupCur.next 
        #     if next is None:
        #         return newHead