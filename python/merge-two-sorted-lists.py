# https://leetcode.com/problems/merge-two-sorted-lists/
from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        leftNode = list1        
        rightNode = list2
        
        head = None 
        tail = None
        while True:
            if leftNode is None and rightNode is None:
                break
            cur = head
            if leftNode is None:
                head = ListNode(rightNode.val, None)
                rightNode = rightNode.next
            elif rightNode is None:
                head = ListNode(leftNode.val, None) 
                leftNode = leftNode.next
            else:
                leftVal = leftNode.val
                rightVal = rightNode.val
                if leftVal < rightVal:
                    head = ListNode(leftVal, None) 
                    leftNode = leftNode.next
                else:
                    head = ListNode(rightVal, None)
                    rightNode = rightNode.next
            if cur is not None:
                cur.next = head
            if tail is None:
                tail = head
        return tail

# ll = Solution().mergeTwoLists(
#     ListNode(1, ListNode(2, ListNode(4, None))),
#     ListNode(1, ListNode(3, ListNode(4, None)))
# )
ll = Solution().mergeTwoLists(
    ListNode(1, None),
    None)
while ll is not None:
    print(ll.val)
    ll = ll.next
