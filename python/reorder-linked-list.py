# https://leetcode.com/problems/reorder-list/
from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        asList = []
        cur = head
        while cur is not None:
            asList.append(cur)
            cur = cur.next
        
        head = asList[0]
        for i in range(1, asList.__len__()):
            halveIndex = i // 2
            node = asList[halveIndex] if i % 2 == 0 else asList[asList.__len__() - halveIndex - 1]
            head.next = node
            head = node 
        
        head.next = None 
        """
        Do not return anything, modify head in-place instead.
        """

ll = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, None)))))
Solution().reorderList(ll)
while ll is not None:
    print(ll.val)
    ll = ll.next
