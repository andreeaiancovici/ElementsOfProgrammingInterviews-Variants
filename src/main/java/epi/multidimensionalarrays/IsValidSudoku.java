package epi.multidimensionalarrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;

/*
Check whether a 9 X 9 2D array representing a partially completed Sudoku is valid.
Specifically, check that no row, column, or 3 X 3 2D sub-array contains duplicates. A
0-value in the 2D array indicates that entry is blank; every other entry is in [1,9].
Time Complexity: O(n^2)
Space Complexity: O(n)
 */
public class IsValidSudoku {

    public static void main(String[] args) {
        assertFalse(isValidSudoku(Arrays.asList(
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 1, 2, 0, 0),
                Arrays.asList(0, 0, 0, 0, 6, 0, 4, 0, 0),
                Arrays.asList(0, 0, 0, 2, 0, 0, 0, 0, 5),
                Arrays.asList(7, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 8, 3, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 3, 3, 0),
                Arrays.asList(0, 0, 4, 0, 0, 0, 0, 0, 0)
        )));
    }

    public static boolean isValidSudoku(List<List<Integer>> partialAssignment) {
        int size = partialAssignment.size();

        for(int i = 0; i < size; i++) {
            if (hasDuplicate(partialAssignment, i, i + 1, 0, size)) {
                return false;
            }
        }

        for(int j = 0; j < size; j++) {
            if (hasDuplicate(partialAssignment, 0, size, j, j + 1)) {
                return false;
            }
        }

        int sizeSquare = size / 3;
        int noSquares = sizeSquare * sizeSquare;
        for(int k = 0; k < noSquares; k++) {
            if (hasDuplicate(partialAssignment, sizeSquare * (k / sizeSquare), sizeSquare * (k / sizeSquare) + sizeSquare,
                    sizeSquare * (k % sizeSquare), sizeSquare * (k % sizeSquare) + sizeSquare)) {
                return false;
            }
        }

        return true;
    }

    private static boolean hasDuplicate(List<List<Integer>> partialAssignment, int startRow, int endRow,
                                        int startColumn, int endColumn) {
        Set<Integer> numbers = new HashSet<>();
        for(int i = startRow; i < endRow; i++) {
            for (int j = startColumn; j < endColumn; j++) {
                Integer number = partialAssignment.get(i).get(j);
                if(number != 0) {
                    if (numbers.contains(number)) {
                        return true;
                    } else numbers.add(number);
                }
            }
        }
        return false;
    }
}
