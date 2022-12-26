# https://leetcode.com/problems/top-k-frequent-elements/
from typing import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        occurrences = {}
        for num in nums:
            if num in occurrences:
                occurrences[num] += 1
            else:
                occurrences[num] = 1
        sortedOccurences = sorted(occurrences.items(), key=lambda x: x[1], reverse=True) 
        return [x[0] for x in sortedOccurences[:k]]

print(Solution().topKFrequent([1,1,1,2,2,3], 2))
print(Solution().topKFrequent([1], 1))