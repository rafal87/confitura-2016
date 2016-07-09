package pl.chrupala.confitura2016.layeredtree;

import org.junit.Assert;
import org.junit.Test;

public class LayeredTreeSolverTest {

    @Test
    public void testSample() {
        int[] values = {5, 4, 3, 2, 1};
        Integer[][] expected = {
                {1},
                {3, 2},
                {4, 5, null, null}
        };

        LayeredTreeSolver solver = new LayeredTreeSolver();
        Integer[][] result = solver.solve(values);

        assertLayersEquals(expected, result);
    }

    @Test
    public void testSample2() {
        int[] values = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        Integer[][] expected = {
                {1},
                {3, 2},
                {4, 5, 6, 7},
                {null, null, null, null, null, null, 9, 8}
        };

        LayeredTreeSolver solver = new LayeredTreeSolver();
        Integer[][] result = solver.solve(values);

        assertLayersEquals(expected, result);
    }

    @Test
    public void testSingle() {
        int[] values = {1};
        Integer[][] expected = {{1}};

        LayeredTreeSolver solver = new LayeredTreeSolver();
        Integer[][] result = solver.solve(values);

        assertLayersEquals(expected, result);
    }

    private void assertLayersEquals(Integer[][] expected, Integer[][] actual) {
        Assert.assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i]);
        }
    }
}
