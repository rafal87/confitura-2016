package pl.chrupala.confitura2016.layeredtree;

import java.io.OutputStream;
import java.io.PrintWriter;

public class LayerWriter {

    private PrintWriter printWriter;

    public LayerWriter(OutputStream outputStream) {
        this.printWriter = new PrintWriter(outputStream);
    }

    public void write(Integer[][] layers) {
        for (int i = 0; i < layers.length; i++) {
            for (int j = 0; j < layers[i].length; j++) {
                printWriter.print(layers[i][j] != null ? layers[i][j] : "_");
                if (j != layers[i].length - 1) {
                    printWriter.print(",");
                }
            }
            printWriter.println();
        }
        printWriter.flush();
    }
}
