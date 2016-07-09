package pl.chrupala.confitura2016.lazyhiker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class LazyHikerSolverTest {

    @Test
    public void testSample1() {
        int[][] map = {
                {1, 1, 1, 1},
                {1, 2, 3, 1},
                {1, 5, 3, 1},
                {1, 1, 1, 1},
        };

        Set<String> expected = new HashSet<>();
        expected.add("RRRDDD");
        expected.add("DDDRRR");

        LazyHikerSolver solver = new LazyHikerSolver(map);
        Set<String> result = solver.solve();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSample2() {
        int[][] map = {
                {1, 9, 9, 9},
                {1, 1, 1, 9},
                {9, 9, 1, 9},
                {9, 1, 1, 9},
                {9, 1, 9, 9},
                {9, 1, 1, 1},
        };

        Set<String> expected = new HashSet<>();
        expected.add("DRRDDLDDRR");

        LazyHikerSolver solver = new LazyHikerSolver(map);
        Set<String> result = solver.solve();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSingle() {
        int[][] map = {{0}};

        Set<String> expected = Collections.emptySet();

        LazyHikerSolver solver = new LazyHikerSolver(map);
        Set<String> result = solver.solve();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSingleRow() {
        int[][] map = {{1, 2, 1, 2}};

        Set<String> expected = new HashSet<>();
        expected.add("RRR");

        LazyHikerSolver solver = new LazyHikerSolver(map);
        Set<String> result = solver.solve();

        Assert.assertEquals(expected, result);
    }

}
