# https://leetcode.com/problems/remove-nth-node-from-end-of-list/
from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        sizeOfList = 0
        cur = head
        while cur is not None:
            sizeOfList += 1
            cur = cur.next
        
        startRemovingFrom = sizeOfList - n
        if startRemovingFrom == 0:
            return head.next
        cur = head
        for _ in range(startRemovingFrom - 1): 
            cur = cur.next
        cur.next = cur.next.next
        return head

ll = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, None)))))
ll = Solution().removeNthFromEnd(ll, 1)
while ll is not None:
    print(ll.val)
    ll = ll.next
