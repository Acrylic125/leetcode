# https://leetcode.com/problems/evaluate-reverse-polish-notation/
from typing import List

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        numsStack = []
        
        for token in tokens:
            if token.lstrip('-').isdigit():
                numsStack.append(int(token))
            else:
                operand1 = numsStack.pop()
                operand2 = numsStack.pop()
                
                if token == '+':
                    numsStack.append(operand1 + operand2)
                elif token == '-':
                    numsStack.append(operand2 - operand1)
                elif token == '*':
                    numsStack.append(operand1 * operand2)
                elif token == '/':
                    numsStack.append(int(operand2 / operand1))
                else:
                    raise Exception("Invalid token: " + token)
        return numsStack.pop()

print(Solution().evalRPN(["2","1","+","3","*"]))
print(Solution().evalRPN(["4","13","5","/","+"]))
print(Solution().evalRPN(["10","6","9","3","+","-11","*","/","*","17","+","5","+"]))