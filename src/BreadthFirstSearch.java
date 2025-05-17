import java.util.*;

public class BreadthFirstSearch<T> extends Search<T> {

    public BreadthFirstSearch(WeightedGraph<T> graph, T start) {
        super(start);
        bfs(graph, start);
    }

    private void bfs(WeightedGraph<T> graph, T current) {
        Queue<T> queue = new LinkedList<>();
        marked.add(current);
        queue.add(current);

        while (!queue.isEmpty()) {
            T v = queue.remove();
            for (Vertex<T> neighbor : graph.getVertex(v).getAdjacentVertices().keySet()) {
                T neighborData = neighbor.getData();
                if (!marked.contains(neighborData)) {
                    marked.add(neighborData);
                    edgeTo.put(neighborData, v);
                    queue.add(neighborData);
                }
            }
        }
    }
}
