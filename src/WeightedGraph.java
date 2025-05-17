import java.util.*;

public class WeightedGraph<T> {
    private final boolean undirected;
    private final Map<T, Vertex<T>> vertices = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(T data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(T source, T destination, double weight) {
        addVertex(source);
        addVertex(destination);

        Vertex<T> v1 = vertices.get(source);
        Vertex<T> v2 = vertices.get(destination);

        if (!v1.getAdjacentVertices().containsKey(v2)) {
            v1.addAdjacentVertex(v2, weight);
            if (undirected) {
                v2.addAdjacentVertex(v1, weight);
            }
        }
    }

    public Vertex<T> getVertex(T data) {
        return vertices.get(data);
    }

    public Collection<Vertex<T>> getVertices() {
        return vertices.values();
    }

    public List<Vertex<T>> adjacencyList(T data) {
        Vertex<T> v = vertices.get(data);
        if (v == null) return Collections.emptyList();
        return new ArrayList<>(v.getAdjacentVertices().keySet());
    }

    public Double getWeight(T from, T to) {
        Vertex<T> fromVertex = vertices.get(from);
        Vertex<T> toVertex = vertices.get(to);
        return fromVertex != null ? fromVertex.getAdjacentVertices().get(toVertex) : null;
    }
}
