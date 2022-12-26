# https://leetcode.com/problems/two-sum/
from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        weights = {}
        for i in range(nums.__len__()):
            cur = nums[i]
            if cur in weights:
                weights[cur].append(i)
            else:
                weights[cur] = [i]
        for i in range(nums.__len__()):
            alt = target - nums[i]
            if alt in weights:
                altWeights = weights[alt]
                for altWeight in altWeights:
                    if altWeight != i:
                        return [i, altWeight]    
        return []
        
        
print(Solution().twoSum([2,7,11,15], 9))
print(Solution().twoSum([3,2,4], 6))
print(Solution().twoSum([3, 3], 6))
