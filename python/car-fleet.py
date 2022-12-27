# https://leetcode.com/problems/car-fleet/
from typing import List

class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        fleets = {}
        cars = zip(position, speed)
        for car in cars:
            if car[0] >= target:
                continue
            else:
                car[0] += car[1]
                if car[0] >= target:
                    fleets[car[0]] = car[1] 
        while True:
            pass