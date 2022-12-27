# https://leetcode.com/problems/reverse-linked-list/
from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return None
        prev = None
        cur = head
        while True:
            next = cur.next
            cur.next = prev
            prev = cur
            if next is None:
                break
            cur = next
        return cur 
        
ll = Solution().reverseList(ListNode(
    1, ListNode(2, 
                ListNode(3, None))
))
print("Test")
# print(ll.val)
while ll is not None:
    print(ll.val)
    ll = ll.next