import java.util.List;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, int weight);

    List<Vertex> getMinDistance(String startVertex, String endVertex);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

}
