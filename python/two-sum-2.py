# https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
from typing import List

class Solution:
    def binarySearch(self, numbers: List[int], target: int, firstIndex: int, lastIndex: int) -> int:
        cursorDelta = lastIndex - firstIndex
        if cursorDelta == 0:
            if numbers[firstIndex] == target:
                return firstIndex
            return None
        middleIndex = firstIndex + ((lastIndex - firstIndex) // 2)

        cursorLeft = middleIndex - 1
        cursorRight = middleIndex + 1

        # print(f"Checking middle {middleIndex} left {cursorLeft} right {cursorRight}")
        if numbers[middleIndex] == target:
            return middleIndex
        if cursorRight <= lastIndex:
            if numbers[cursorRight] < target:
                # We need to search right.
                return self.binarySearch(numbers, target, cursorRight, lastIndex)
            elif numbers[cursorRight] == target:
                return cursorRight
        
        if cursorLeft >= firstIndex:
            if numbers[cursorLeft] > target:
                # We need to search left.
                return self.binarySearch(numbers, target, firstIndex, cursorLeft)
            elif numbers[cursorLeft] == target:
                return cursorLeft   
         
        return None
    
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        lastIndex = numbers.__len__() - 1
        for (i, num) in enumerate(numbers):
            diff = target - num
            leftIndex = i - 1
            rightIndex = i + 1
            if rightIndex <= lastIndex and diff >= numbers[rightIndex]:
                # We do a binary search on the right.
                # print(f"Searching right for {diff} from {rightIndex} to {lastIndex}")
                res = self.binarySearch(numbers, diff, rightIndex, lastIndex)
                if res is not None:
                    return [i + 1, res + 1]
            if leftIndex >= 0 and diff <= numbers[leftIndex]:
                # We will scan left.
                # print(f"Searching left for {diff} from {0} to {leftIndex}")
                res = self.binarySearch(numbers, diff, 0, leftIndex)
                if res is not None:
                    return [res + 1, i + 1]

print(Solution().twoSum([2,7,11,15], 9))
print(Solution().twoSum([2,3,4], 6))
print(Solution().twoSum([-1,0], -1))
# print(Solution().binarySearch([2,7,6,11], 11, 0, 3))
# print(Solution().binarySearch([2,7,6,11,15], 15, 0, 4))
# print(Solution().binarySearch([2,7,6,11,15,17,19,22,25,30,200,1000], 7, 0, 12))
# print(Solution().binarySearch([-1, 0], -1, 0, 2))