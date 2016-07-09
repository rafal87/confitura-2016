package pl.chrupala.confitura2016.layeredtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputReader {

    private InputStream inputStream;

    public InputReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int[] read() throws IOException, InputFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        if (line == null) {
            throw new InputFormatException("Input must not be empty");
        }
        String[] elements = line.split("[, ]+");
        int[] values = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            try {
                values[i] = Integer.parseInt(elements[i]);
            } catch (NumberFormatException ex) {
                throw new InputFormatException("Input contains illegal characters", ex);
            }
        }
        return values;
    }

}
