/**
 *
 * @param {number} rowIndex
 * @param {number} colIndex
 * @param {number[][]} mem rows and cols of pascal's triangle [row][col]
 * @returns
 */
function imposeValueToMemory(rowIndex = 0, colIndex = 0, mem = []) {
  if (rowIndex === 0 && colIndex === 0) {
    mem[0] = [1];
    return 1;
  }
  if (rowIndex < 0 || colIndex < 0) return 0;

  const row = mem[rowIndex];

  if (row) {
    const cellsInRow = rowIndex + 1;
    const midCol = Math.ceil(cellsInRow / 2);

    var value;
    // To minimise storage, we only store the left half of the triangle
    // and then mirror the values to the right half
    if (colIndex >= midCol) {
      value = row[cellsInRow - 1 - colIndex];
    } else {
      value = row[colIndex];
    }

    if (value !== undefined) return value;
  }

  // Since the value is not memoized, we will calculate it.
  const computedValue = imposeValueToMemory(rowIndex - 1, colIndex - 1, mem) + imposeValueToMemory(rowIndex - 1, colIndex, mem);

  // Then we memoize.
  if (!row) {
    mem[rowIndex] = [];
  }
  mem[rowIndex][colIndex] = computedValue;

  return computedValue;
}

/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function (numRows) {
  const mem = new Array(numRows);

  for (var col = 0; col < numRows; col++) {
    imposeValueToMemory(numRows - 1, col, mem);
  }

  for (var row = 0; row < numRows; row++) {
    const cellsInRow = row + 1;
    const midCol = Math.ceil(cellsInRow / 2);
    for (var col = midCol; col < cellsInRow; col++) {
      mem[row][col] = mem[row][cellsInRow - 1 - col];
    }
  }

  return mem;
};

console.log(generate(30));
