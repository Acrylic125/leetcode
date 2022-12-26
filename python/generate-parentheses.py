# https://leetcode.com/problems/generate-parentheses/
from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return []
        if n == 1:
            return ["()"]
        elif n == 2:
            return ["()()", "(())"]
        # for i in range(n):
             
        # elif n == 3:
        #     return ["()()()", "()(())", "(())()", "(()())", "((()))"]
        # elif n == 4:
        #     return ["()()()()", "()(())()", "(()())()", "((()))()", "(()()())", "((())())", "((()()))", "(()(()))", "(((())))"]
        return self.generateParenthesis(n - 1) + self.generateParenthesis(n - 1)