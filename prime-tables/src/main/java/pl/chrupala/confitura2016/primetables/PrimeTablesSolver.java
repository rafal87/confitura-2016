package pl.chrupala.confitura2016.primetables;

public class PrimeTablesSolver {

    public int solve(int[][] table) {
        int rows = table.length;
        int cols = table.length > 0 ? table[0].length : 0;

        if (rows == 0 || cols == 0) {
            return 0;
        }

        SummedAreaTable sat = new SummedAreaTable(table);
        int biggestSum = sat.getSummedArea(0, 0, rows - 1, cols - 1);
        EratosthenesSieve eratosthenesSieve = new EratosthenesSieve(biggestSum);

        int counter = 0;
        for (int startRow = 0; startRow < rows - 1; startRow++) {
            for (int startCol = 0; startCol < cols - 1; startCol++) {
                for (int endRow = startRow + 1; endRow < rows; endRow++) {
                    for (int endCol = startCol + 1; endCol < cols; endCol++) {
                        int sum = sat.getSummedArea(startRow, startCol, endRow, endCol);
                        if (eratosthenesSieve.isPrime(sum)) {
                            counter++;
                        }
                    }
                }
            }
        }
        return counter;
    }

}
