public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        fillWithWeights(graph);

        System.out.println("Dijkstra:");
        Search<String> dijkstra = new DijkstraSearch<>(graph, "Winterfell");
        outputPath(dijkstra, "Riverrun");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Winterfell");
        outputPath(bfs, "Riverrun");
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Winterfell", "King’s Landing", 2.1);
        graph.addEdge("Dragonstone", "Harrenhal", 7.8);
        graph.addEdge("Harrenhal", "King’s Landing", 7.1);
        graph.addEdge("Winterfell", "Dragonstone", 7.2);
        graph.addEdge("Dragonstone", "King’s Landing", 3.9);
        graph.addEdge("King’s Landing", "Kostanay", 3.5);
        graph.addEdge("Dragonstone", "Riverrun", 5.4);
    }
// игра престолов))
    public static void outputPath(Search<String> search, String key) {
        if (!search.hasPathTo(key)) {
            System.out.println("No path to " + key);
            return;
        }

        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
        System.out.println("END");
    }
}
