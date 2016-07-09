package pl.chrupala.confitura2016.primetables;

public class SummedAreaTable {

    private final int[][] sat;

    public SummedAreaTable(int[][] input) {
        int rows = input.length;
        int cols = input[0].length;
        sat = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sat[row][col] = input[row][col]
                        + (row > 0 ? sat[row - 1][col] : 0)
                        + (col > 0 ? sat[row][col - 1] : 0)
                        - (row > 0 && col > 0 ? sat[row - 1][col - 1] : 0);
            }
        }
    }

    public int getSummedArea(int startRow, int startCol, int endRow, int endCol) {
        return sat[endRow][endCol]
                + (startRow > 0 && startCol > 0 ? sat[startRow - 1][startCol - 1] : 0)
                - (startRow > 0 ? sat[startRow - 1][endCol] : 0)
                - (startCol > 0 ? sat[endRow][startCol - 1] : 0);
    }
}
