public class Main {

    public static void main(String[] args) {
//
//        Graph graph = new Graph(9, false);
//        graph.addEdge(0, 1, 4);
//        graph.addEdge(0, 7, 8);
//        graph.addEdge(1,7,11);
//        graph.addEdge(1,2,8);
//        graph.addEdge(2,8,2);
//        graph.addEdge(8,7,7);
//        graph.addEdge(7,6,1);
//        graph.addEdge(8,6,6);
//        graph.addEdge(2,5,4);
//        graph.addEdge(2,3,7);
//        graph.addEdge(3,5,14);
//        graph.addEdge(3,4,9);
//        graph.addEdge(4,5,10);
//        graph.addEdge(5,6,2);
//        graph.generatePrimsMST(0);


        Graph graph = new Graph(5, true);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 4, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 2, 6);
        graph.addEdge(3, 0, 7);
        graph.addEdge(4, 3, 2);
        graph.addEdge(4, 2, 9);
        graph.addEdge(4, 1, 3);
        graph.printGraph();

        graph.findShortestPaths(0);



    }
}
