# https://leetcode.com/problems/valid-sudoku/
from typing import List

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = board.__len__()
        cols = board[0].__len__()
        
        # Scan the rows
        for row in range(rows):
            values = set()    
            for col in range(cols):
                val = board[row][col]
                if val == ".":
                    continue
                if val in values:
                    return False
                values.add(val)
        
        # Scan the columns
        for col in range(cols):
            values = set()
            for row in range(rows):
                val = board[row][col]
                if val == ".":
                    continue
                if val in values:
                    return False 
                values.add(val)
        
        # Scan the 3x3 squares
        for startRow in range(0, rows, 3):
            for startCol in range(0, cols, 3):
                values = set()
                for row in range(startRow, startRow + 3):
                    for col in range(startCol, startCol + 3):
                        val = board[row][col]
                        if val == ".":
                            continue
                        if val in values:
                            return False
                        values.add(val)
        return True


print(Solution().isValidSudoku(
    [["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]))
print(Solution().isValidSudoku(
    [["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]))