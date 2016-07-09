package pl.chrupala.confitura2016.layeredtree;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

public class LayerWriterTest {

    @Test
    public void test1() {
        Integer[][] layers = {
                {1},
                {3, 2},
                {4, 5, null, null}
        };
        String expected = "1\n" +
                "3,2\n" +
                "4,5,_,_\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        LayerWriter layerWriter = new LayerWriter(outputStream);
        layerWriter.write(layers);

        Assert.assertEquals(expected, outputStream.toString());
    }

    @Test
    public void test2() {
        Integer[][] layers = {
                {1},
                {3, 2},
                {4, 5, 6, 7},
                {null, null, null, null, null, null, 9, 8}
        };
        String expected = "1\n" +
                "3,2\n" +
                "4,5,6,7\n" +
                "_,_,_,_,_,_,9,8\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        LayerWriter layerWriter = new LayerWriter(outputStream);
        layerWriter.write(layers);

        Assert.assertEquals(expected, outputStream.toString());
    }

}
