package pl.chrupala.confitura2016.layeredtree;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class InputReaderTest {

    @Test
    public void testValidSample() throws IOException, InputFormatException {
        String input = "5,4,3,2,1";
        int[] expected = {5, 4, 3, 2, 1};

        InputReader inputReader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        int[] values = inputReader.read();
        Assert.assertArrayEquals(expected, values);
    }

    @Test(expected = InputFormatException.class)
    public void testEmptyInput() throws IOException, InputFormatException {
        String input = "";
        InputReader inputReader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        inputReader.read();
    }

    @Test(expected = InputFormatException.class)
    public void testInvalidCharacters() throws IOException, InputFormatException {
        String input = "1,1,1x,1";
        InputReader inputReader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        inputReader.read();
    }

}
