# https://leetcode.com/problems/copy-list-with-random-pointer/
from typing import Optional

"""
# Definition for a Node.
"""
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        copyAsList = []
        prev = None
        cur = head
        while cur is not None:
            newNode = Node(cur.val, None, None)
            if prev is not None:
                prev.next = newNode
            copyAsList.append(newNode)
            cur = cur.next
        
        for node in copyAsList:
            if node.random is not None:
                pass