import java.util.Arrays;

public class Lesson7 {

    private static final String START_LABEL = "Москва";

    public static void main(String[] args) {
        var graph = createGraph();

        var result = graph.getMinDistance(START_LABEL);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private static Graph createGraph() {
        var graph = new GraphImpl(10);

        graph.addVertex(START_LABEL);
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge(START_LABEL, "Тула", 183);
        graph.addEdge(START_LABEL, "Рязань", 199);
        graph.addEdge(START_LABEL, "Калуга", 181);
        graph.addEdge("Тула", "Липецк", 292);
        graph.addEdge("Рязань", "Тамбов", 288);
        graph.addEdge("Калуга", "Орел", 212);
        graph.addEdge("Липецк", "Воронеж", 126);
        graph.addEdge("Тамбов", "Саратов", 386);
        graph.addEdge("Орел", "Курск", 163);
        graph.addEdge("Саратов", "Воронеж", 511);
        graph.addEdge("Курск", "Воронеж", 227);

        return graph;
    }
}
