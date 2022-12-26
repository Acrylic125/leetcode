# https://leetcode.com/problems/contains-duplicate/
from typing import List

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        contains = set()
        for num in nums:
            if num in contains:
                return True
            contains.add(num)
        return False 
        
        
print(Solution().containsDuplicate([1,2,3,4]))