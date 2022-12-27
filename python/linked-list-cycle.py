# https://leetcode.com/problems/linked-list-cycle/
from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        checked = set()
        cur = head 
        while cur is not None:
            if cur in checked:
                return True
            checked.add(cur)
            cur = cur.next
        return False


a = ListNode(3)
b = ListNode(2)
c = ListNode(0)
d = ListNode(-4)
a.next = b
b.next = c
c.next = d
d.next = None 
print(Solution().hasCycle(a))