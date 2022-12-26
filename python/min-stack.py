# https://leetcode.com/problems/min-stack/

class MinStackNode:
    def __init__(self, val, min, parent):
        self.val = val
        self.min = min
        self.parent = parent

class MinStack:

    def __init__(self):
        self.topNode = None

    def push(self, val: int) -> None:
        parent = self.topNode
        node = MinStackNode(val, 
                            val if parent is None else min(val, parent.min),
                            parent)
        self.topNode = node

    def pop(self) -> None:
        self.topNode = self.topNode.parent

    def top(self) -> int:
        return self.topNode.val 

    def getMin(self) -> int:
        return self.topNode.min


# Your MinStack object will be instantiated and called as such:
minStack = MinStack()
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
print(minStack.getMin()); # return -3
minStack.pop();
print(minStack.top());    # return 0
print(minStack.getMin()); # return -2