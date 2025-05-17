import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private final Map<T, Double> distances;
    private final WeightedGraph<T> graph;
    private final Set<T> unsettled;

    public DijkstraSearch(WeightedGraph<T> graph, T source) {
        super(source);
        this.graph = graph;
        this.distances = new HashMap<>();
        this.unsettled = new HashSet<>();
        dijkstra();
    }

    private void dijkstra() {
        distances.put(source, 0.0);
        unsettled.add(source);

        while (!unsettled.isEmpty()) {
            T current = getMinimum(unsettled);
            unsettled.remove(current);
            marked.add(current);

            for (Vertex<T> neighborVertex : graph.getVertex(current).getAdjacentVertices().keySet()) {
                T neighbor = neighborVertex.getData();
                double newDist = distances.get(current) +
                        graph.getVertex(current).getAdjacentVertices().get(neighborVertex);
                if (newDist < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    unsettled.add(neighbor);
                }
            }
        }
    }

    private T getMinimum(Set<T> vertices) {
        T minimum = null;
        for (T v : vertices) {
            if (minimum == null || distances.getOrDefault(v, Double.MAX_VALUE) < distances.getOrDefault(minimum, Double.MAX_VALUE)) {
                minimum = v;
            }
        }
        return minimum;
    }
}
