# https://leetcode.com/problems/merge-k-sorted-lists/
from typing import List, Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if lists.__len__() == 0:
            return None
        tail = None 
        head = None 
        
        while True:
            lowest = None
            for (i, list) in enumerate(lists):
                if list is None:
                    continue
                if lowest is None or list.val < lowest[1]:
                    lowest = (i, list.val)
            
            if lowest is None:
                return head

            index = lowest[0]
            cur = lists[index]
            lists[index] = cur.next
            if lists[index] is None:
                lists.pop(index)

            if tail is not None:
                tail.next = cur
            tail = cur
                
            if head is None:
                head = tail

a = ListNode(1, ListNode(4, ListNode(5)))
b = ListNode(1, ListNode(3, ListNode(4)))
c = ListNode(2, ListNode(6))
ll = Solution().mergeKLists([a, b, c])
while ll is not None:
    print(ll.val)
    ll = ll.next

