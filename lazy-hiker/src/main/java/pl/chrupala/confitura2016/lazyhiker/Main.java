package pl.chrupala.confitura2016.lazyhiker;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try {
            InputReader inputReader = new InputReader(System.in);
            int[][] map = inputReader.read();

            LazyHikerSolver solver = new LazyHikerSolver(map);
            Set<String> result = solver.solve();

            for (String directions : result) {
                System.out.println(directions);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
