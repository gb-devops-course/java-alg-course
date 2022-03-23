import java.util.Arrays;

public class Lesson7 {

    public static void main(String[] args) {
        var graph = createGraph();

        var minVertexes = graph.getMinDistance("A", "D");
        System.out.println(Arrays.toString(minVertexes.toArray()));
    }

    private static Graph createGraph() {
        var graph = new GraphImpl(5);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("E");
        graph.addVertex("D");

        graph.addEdge("A", "B", 10);
        graph.addEdge("A", "C", 10);
        graph.addEdge("B", "E", 1);
        graph.addEdge("E", "D", 2);
        graph.addEdge("C", "D", 10);

//        var graph = new GraphImpl(10);

//        graph.addVertex("Москва");
//        graph.addVertex("Тула");
//        graph.addVertex("Рязань");
//        graph.addVertex("Калуга");
//        graph.addVertex("Липецк");
//        graph.addVertex("Тамбов");
//        graph.addVertex("Орел");
//        graph.addVertex("Саратов");
//        graph.addVertex("Курск");
//        graph.addVertex("Воронеж");
//
//        graph.addEdge("Москва", "Тула", 10);
//        graph.addEdge("Москва", "Рязань", 2);
//        graph.addEdge("Москва", "Калуга", 10);
//        graph.addEdge("Тула", "Липецк", 10);
//        graph.addEdge("Рязань", "Тамбов", 10);
//        graph.addEdge("Калуга", "Орел", 10);
//        graph.addEdge("Липецк", "Воронеж", 10);
//        graph.addEdge("Тамбов", "Саратов", 1);
//        graph.addEdge("Орел", "Курск", 6);
//        graph.addEdge("Саратов", "Воронеж", 10);
//        graph.addEdge("Курск", "Воронеж", 10);

//        graph.addEdge("Москва", "Тула", 183);
//        graph.addEdge("Москва", "Рязань", 199);
//        graph.addEdge("Москва", "Калуга", 181);
//        graph.addEdge("Тула", "Липецк", 292);
//        graph.addEdge("Рязань", "Тамбов", 288);
//        graph.addEdge("Калуга", "Орел", 212);
//        graph.addEdge("Липецк", "Воронеж", 126);
//        graph.addEdge("Тамбов", "Саратов", 386);
//        graph.addEdge("Орел", "Курск", 163);
//        graph.addEdge("Саратов", "Воронеж", 511);
//        graph.addEdge("Курск", "Воронеж", 227);

        return graph;
    }
}
