package pl.chrupala.confitura2016.layeredtree;

import java.util.Arrays;

public class LayeredTreeSolver {

    public Integer[][] solve(int[] values) {
        Arrays.sort(values);

        int numberOfValues = values.length;
        int numberOfLayers = (int) Math.floor(Math.log(numberOfValues) / Math.log(2)) + 1;
        Integer[][] layers = new Integer[numberOfLayers][];
        int pos = 0;
        for (int i = 0; i < numberOfLayers; i++) {
            int layerCapacity = 1 << i; // 2^i
            layers[i] = new Integer[layerCapacity];
            if (i % 2 == 0) {
                // natural order
                for (int j = 0; j < layerCapacity; j++) {
                    if (pos < numberOfValues) {
                        layers[i][j] = values[pos];
                        pos++;
                    } else {
                        break;
                    }
                }
            } else {
                // reverse order
                for (int j = layerCapacity - 1; j >= 0; j--) {
                    if (pos < numberOfValues) {
                        layers[i][j] = values[pos];
                        pos++;
                    } else {
                        break;
                    }
                }
            }
        }
        return layers;
    }
}
