import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, int weight);

    List<Vertex> getMinDistance(String startVertex);

    int getSize();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

    @Data
    @RequiredArgsConstructor
    class Pair<T, V> {
        private final T first;
        private final V second;
    }
}
