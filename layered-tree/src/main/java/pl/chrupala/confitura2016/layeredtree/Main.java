package pl.chrupala.confitura2016.layeredtree;

public class Main {

    public static void main(String[] args) {
        try {
            InputReader inputReader = new InputReader(System.in);
            int[] values = inputReader.read();

            LayeredTreeSolver solver = new LayeredTreeSolver();
            Integer[][] layers = solver.solve(values);

            LayerWriter layerWriter = new LayerWriter(System.out);
            layerWriter.write(layers);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
