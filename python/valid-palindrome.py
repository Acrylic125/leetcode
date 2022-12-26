# https://leetcode.com/problems/valid-palindrome/

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        sSplit = list(s)
        split = []

        for char in sSplit:
            if char.isalnum():
                split.append(char)

        for i in range(0, split.__len__() // 2):
            alt = split[split.__len__() - i - 1]
            if alt != split[i]:
                return False
        return True

print(Solution().isPalindrome("A man, a plan, a canal: Panama"))
print(Solution().isPalindrome("race a car"))
print(Solution().isPalindrome(" "))
print(Solution().isPalindrome("0P"))