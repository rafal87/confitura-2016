package pl.chrupala.confitura2016.primetables;

import org.junit.Assert;
import org.junit.Test;

public class SummedAreaTableTest {

    @Test
    public void testSample() {
        int[][] table = {
                {1, 1, 1, 1},
                {1, 2, 1, 1},
                {1, 1, 1, 1},
        };
        SummedAreaTable sat = new SummedAreaTable(table);
        Assert.assertEquals(13, sat.getSummedArea(0, 0, 2, 3));
        Assert.assertEquals(5, sat.getSummedArea(1, 1, 2, 2));
        Assert.assertEquals(4, sat.getSummedArea(0, 0, 0, 3));
    }

    @Test
    public void testSingle() {
        int[][] table = {{5}};
        SummedAreaTable sat = new SummedAreaTable(table);
        Assert.assertEquals(5, sat.getSummedArea(0, 0, 0, 0));
    }

}
