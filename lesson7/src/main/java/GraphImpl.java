import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final Integer[][] adjMatrix;

    private final List<Vertex> visitedVertexes = new ArrayList<>();

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new Integer[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int weight) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = weight;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    public List<Vertex> getMinDistance(String startVertex, String endVertex) {
        visitedVertexes.clear();
        int startIndex = indexOf(startVertex);

        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startVertex);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            int currentIndex = vertexList.indexOf(queue.peek());
            vertex = getNearUnvisitedVertex(currentIndex);
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }

        return List.of();
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] != null) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void dfs(String startLabel) {
        visitedVertexes.clear();

        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitAndPrintVertex(stack, vertex);
        while (!stack.isEmpty()) {
            int currentIndex = vertexList.indexOf(stack.peek());
            vertex = getNearUnvisitedVertex(currentIndex);
            if (vertex != null) {
                visitAndPrintVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
    }

    private Vertex getNearUnvisitedVertex(int currentIndex) {
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] != null && !visitedVertexes.contains(vertexList.get(i))) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitAndPrintVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        visitVertex(stack, vertex);
    }

    private void visitAndPrintVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        visitVertex(queue, vertex);
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        stack.push(vertex);
        visitedVertexes.add(vertex);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        queue.add(vertex);
        visitedVertexes.add(vertex);
    }

    @Override
    public void bfs(String startLabel) {
        visitedVertexes.clear();

        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitAndPrintVertex(queue, vertex);
        while (!queue.isEmpty()) {
            int currentIndex = vertexList.indexOf(queue.peek());
            vertex = getNearUnvisitedVertex(currentIndex);
            if (vertex != null) {
                visitAndPrintVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
    }
}
