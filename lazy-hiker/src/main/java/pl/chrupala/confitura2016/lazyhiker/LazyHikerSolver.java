package pl.chrupala.confitura2016.lazyhiker;

import java.util.*;
import java.util.stream.Collectors;

public class LazyHikerSolver {

    private int[][] map;
    private int rows;
    private int cols;

    public LazyHikerSolver(int[][] map) {
        this.map = map;
        this.rows = map.length;
        this.cols = map.length > 0 ? map[0].length : 0;
    }

    public Set<String> solve() {
        Vertex begin = new Vertex(0, 0);
        Vertex end = new Vertex(rows - 1, cols - 1);

        int[][] dist = dijkstra(begin, end);
        List<List<Vertex>> shortestPaths = findAllShortestPaths(begin, end, dist);

        return shortestPaths.stream()
                .map(this::findDirections)
                .collect(Collectors.toSet());
    }

    private int[][] dijkstra(Vertex begin, Vertex end) {
        boolean[][] visited = new boolean[rows][cols];

        int[][] dist = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dist[row][col] = Integer.MAX_VALUE;
            }
        }
        dist[begin.getRow()][begin.getCol()] = 0;

        PriorityQueue<Vertex> q = new PriorityQueue<>((v1, v2) -> {
            return Integer.compare(
                    dist[v1.getRow()][v1.getCol()],
                    dist[v2.getRow()][v2.getCol()]
            );
        });
        q.add(begin);

        while (!q.isEmpty()) {
            Vertex current = q.poll();

            visited[current.getRow()][current.getCol()] = true;

            // If end vertex was visited and the cost of the shortest path is known,
            // keep searching until all possibly equal paths are found.
            // Interrupt when current vertex estimation is greater than that of the end vertex.
            if (visited[end.getRow()][end.getCol()]
                    && dist[current.getRow()][current.getCol()] > dist[end.getRow()][end.getCol()]) {
                break;
            }

            for (Vertex next : getNeighbours(current)) {
                if (!visited[next.getRow()][next.getCol()]) {
                    int d = dist[current.getRow()][current.getCol()] + getAscentCost(current, next);
                    if (d < dist[next.getRow()][next.getCol()]) {
                        dist[next.getRow()][next.getCol()] = d;
                        q.remove(next);
                        q.add(next);
                    }
                }
            }
        }
        return dist;
    }

    private List<Vertex> getNeighbours(Vertex v) {
        List<Vertex> list = new LinkedList<>();
        if (v.getRow() > 0) {
            list.add(new Vertex(v.getRow() - 1, v.getCol()));
        }
        if (v.getRow() + 1 < rows) {
            list.add(new Vertex(v.getRow() + 1, v.getCol()));
        }
        if (v.getCol() > 0) {
            list.add(new Vertex(v.getRow(), v.getCol() - 1));
        }
        if (v.getCol() + 1 < cols) {
            list.add(new Vertex(v.getRow(), v.getCol() + 1));
        }
        return list;
    }

    private int getAscentCost(Vertex a, Vertex b) {
        int heightDiff = map[b.getRow()][b.getCol()] - map[a.getRow()][a.getCol()];
        return heightDiff > 0 ? heightDiff : 0;
    }

    private List<List<Vertex>> findAllShortestPaths(Vertex begin, Vertex end, int[][] dist) {
        List<List<Vertex>> paths = new LinkedList<>();
        // traverse map from end to begin to find all shortest paths
        // dfs method reverses path before adding it to paths list
        LinkedList<Vertex> path = new LinkedList<>();
        path.add(end);
        dfs(paths, path, begin, dist);
        return paths;
    }

    private void dfs(List<List<Vertex>> paths, LinkedList<Vertex> path, Vertex finalVertex, int[][] dist) {
        Vertex previous = path.getLast();
        for (Vertex next : getNeighbours(previous)) {
            if (dist[previous.getRow()][previous.getCol()] == dist[next.getRow()][next.getCol()] + getAscentCost(next, previous)
                    && !path.contains(next)) {
                path.add(next);
                if (next.equals(finalVertex)) {
                    // Add reversed copy of path to result list
                    ArrayList<Vertex> reversed = new ArrayList<>(path.size());
                    for (int i = path.size() - 1; i >= 0; i--) {
                        reversed.add(path.get(i));
                    }
                    paths.add(reversed);
                } else {
                    dfs(paths, path, finalVertex, dist);
                }
                path.remove(path.size() - 1);
            }
        }
    }

    private String findDirections(List<Vertex> path) {
        StringBuilder sb = new StringBuilder(path.size());
        for (int i = 0; i + 1 < path.size(); i++) {
            Vertex a = path.get(i);
            Vertex b = path.get(i + 1);
            if (a.getRow() + 1 == b.getRow()) {
                sb.append('D');
            } else if (a.getRow() - 1 == b.getRow()) {
                sb.append('U');
            } else if (a.getCol() + 1 == b.getCol()) {
                sb.append('R');
            } else if (a.getCol() - 1 == b.getCol()) {
                sb.append('L');
            }
        }
        return sb.toString();
    }

}
