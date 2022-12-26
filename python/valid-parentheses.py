# https://leetcode.com/problems/valid-parentheses/

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        split = list(s)
        
        for char in split:
            if char == '(' or char == '[' or char =='{':
                stack.append(char)
            else:
                if stack.__len__() == 0:
                    return False
                lastChar = stack.pop()
                if char == ')' and lastChar != '(':
                    return False
                elif char == ']' and lastChar != '[':
                    return False
                elif char == '}' and lastChar != '{':
                    return False
        return stack.__len__() == 0

print(Solution().isValid("()"))
print(Solution().isValid("[])"))
print(Solution().isValid("()[]{}"))
print(Solution().isValid("(]"))
print(Solution().isValid("([]{{}})"))
