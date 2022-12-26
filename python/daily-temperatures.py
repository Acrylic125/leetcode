# https://leetcode.com/problems/daily-temperatures/
from typing import List

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        previousUnresolved = []
        result = [0] * temperatures.__len__()
        for (i, temp) in enumerate(temperatures):
            while previousUnresolved.__len__() > 0 and previousUnresolved[-1][1] < temp:
                prev = previousUnresolved.pop() 
                result[prev[0]] = i - prev[0]
            previousUnresolved.append((i, temp))
        return result


print(Solution().dailyTemperatures([73,74,75,71,69,72,76,73]))
print(Solution().dailyTemperatures([30,40,50,60]))
print(Solution().dailyTemperatures([30,60,90]))
print(Solution().dailyTemperatures([40,50,20,21,22,23,60]))
print(Solution().dailyTemperatures([1, 2]))
