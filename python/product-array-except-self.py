# https://leetcode.com/problems/product-of-array-except-self/
from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        results = [0] * nums.__len__()
        accum = 1
        for (i, num) in enumerate(nums):
            results[i] = accum
            accum *= num
        
        accum = 1
        for i in range(nums.__len__() - 1, -1, -1):
            results[i] *= accum
            accum *= nums[i]
        return results

print(Solution().productExceptSelf([1,2,3,4]))
print(Solution().productExceptSelf([-1,1,0,-3,3]))