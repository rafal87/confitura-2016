package pl.chrupala.confitura2016.primetables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class InputReader {

    private InputStream inputStream;

    public InputReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int[][] read() throws IOException, InputFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        List<int[]> rows = new LinkedList<>();
        while ((line = reader.readLine()) != null) {
            String[] elements = line.split("[, ]+");
            int[] row = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                try {
                    row[i] = Integer.parseInt(elements[i]);
                } catch (NumberFormatException ex) {
                    throw new InputFormatException("Input table contains illegal characters", ex);
                }
                if (row[i] < 0) {
                    throw new InputFormatException("Table elements must be greater than or equal to 0");
                }
            }
            if (rows.size() > 0 && row.length != rows.get(0).length) {
                throw new InputFormatException("Each row must have equal number of elements");
            }
            rows.add(row);
        }
        return rows.toArray(new int[0][0]);
    }
}
