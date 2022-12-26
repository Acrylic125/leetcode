# https://leetcode.com/problems/valid-anagram/

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        charCounts = {}
        split = list(s)
        for char in split:
            if char in charCounts:
                charCounts[char] += 1
            else:
                charCounts[char] = 1
       
        tSplit = list(t)
        if (tSplit.__len__() != split.__len__()):
            return False
        for char in tSplit:
            if char in charCounts:
                if charCounts[char] == 0:
                    return False
                charCounts[char] -= 1
            else:
                return False
        return True


print(Solution().isAnagram("anagram", "nagaram"))
print(Solution().isAnagram("rat", "car"))