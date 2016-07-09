package pl.chrupala.confitura2016.primetables;

import org.junit.Assert;
import org.junit.Test;

public class PrimeTablesSolverTest {

    @Test
    public void testSample() {
        int[][] table = {
                {1, 1, 1, 1},
                {1, 2, 1, 1},
                {1, 1, 1, 1},
        };
        PrimeTablesSolver solver = new PrimeTablesSolver();
        int result = solver.solve(table);
        Assert.assertEquals(11, result);
    }

    @Test
    public void testEmpty() {
        int[][] table = new int[0][0];
        PrimeTablesSolver solver = new PrimeTablesSolver();
        int result = solver.solve(table);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testSingleValue() {
        int[][] table = {{5}};
        PrimeTablesSolver solver = new PrimeTablesSolver();
        int result = solver.solve(table);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testSingleSquare() {
        int[][] table = {
                {1, 3},
                {2, 1}
        };
        PrimeTablesSolver solver = new PrimeTablesSolver();
        int result = solver.solve(table);
        Assert.assertEquals(1, result);
    }
}
