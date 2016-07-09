package pl.chrupala.confitura2016.primetables;

public class Main {

    public static void main(String[] args) {
        try {
            InputReader inputReader = new InputReader(System.in);
            int[][] table = inputReader.read();

            PrimeTablesSolver solver = new PrimeTablesSolver();
            int result = solver.solve(table);

            System.out.println(result);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
