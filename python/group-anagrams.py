# https://leetcode.com/problems/group-anagrams/
from typing import List

class Solution:
    def hashString(self, s: str) -> str:
        split = list(s)
        allCharsArray = [0] * 26
        for char in split:
           charIndex = ord(char) - ord('a') 
           allCharsArray[charIndex] += 1
        return allCharsArray.__str__()
    
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = {}
        for str in strs:
            hashed = self.hashString(str)
            if hashed in groups:
                groups[hashed].append(str)
            else:
                groups[hashed] = [str]
        return list(groups.values())
    
# print(Solution().twoSum([2,7,11,15], 9))
print(Solution().groupAnagrams(["eat","tea","tan","ate","nat","bat"]))
print(Solution().groupAnagrams([""]))
print(Solution().groupAnagrams(["a"]))
