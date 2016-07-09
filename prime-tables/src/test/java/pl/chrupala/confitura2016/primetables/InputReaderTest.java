package pl.chrupala.confitura2016.primetables;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class InputReaderTest {

    @Test
    public void testValidSample() throws IOException, InputFormatException {
        String input = "1,1,1,1\n" +
                "1,2,1,1\n" +
                "1,1,1,1";

        int[][] expected = {
                {1, 1, 1, 1},
                {1, 2, 1, 1},
                {1, 1, 1, 1}
        };

        InputReader inputReader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        int[][] result = inputReader.read();

        Assert.assertEquals(expected.length, result.length);
        for (int row = 0; row < expected.length; row++) {
            Assert.assertArrayEquals(expected[row], result[row]);
        }
    }

    @Test
    public void testEmptyInput() throws IOException, InputFormatException {
        String input = "";
        InputReader inputReader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        int[][] result = inputReader.read();
        Assert.assertEquals(result.length, 0);
    }

    @Test
    public void testSingleValue() throws IOException, InputFormatException {
        String input = "1";
        InputReader inputReader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        int[][] result = inputReader.read();
        Assert.assertEquals(result.length, 1);
        Assert.assertArrayEquals(result[0], new int[]{1});
    }

    @Test(expected = InputFormatException.class)
    public void testInvalidCharacters() throws IOException, InputFormatException {
        String input = "1,1\n" +
                "1x,1";
        InputReader inputReader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        inputReader.read();
    }

    @Test(expected = InputFormatException.class)
    public void testUnevenRows() throws IOException, InputFormatException {
        String input = "1,1,1\b" +
                "1,1\n" +
                "1,1,1";
        InputReader inputReader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        inputReader.read();
    }

    @Test(expected = InputFormatException.class)
    public void testNegativeValues() throws IOException, InputFormatException {
        String input = "1,1\n" +
                "1,-1";
        InputReader inputReader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        inputReader.read();
    }

}
