import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Graph {

    private boolean directed;
    private LinkedList<Vertex> [] adjacencyList;
    private int numberOfVertices;
    private Vertex[] arrayOfVertices;
    private LinkedList<Edge> listOfEdges;



    public Graph(int numberOfVertices, boolean directed) {
        this.directed = directed;
        this.numberOfVertices = numberOfVertices;
        arrayOfVertices = new Vertex[numberOfVertices];
        this.adjacencyList = new LinkedList[numberOfVertices];
        this.listOfEdges = new LinkedList<>();

        for(int i=0; i<numberOfVertices; i++)
        {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void generatePrimsMST(int root) {

        for(int i=0; i<numberOfVertices; i++)
        {
            arrayOfVertices[i] = new Vertex(i);
            arrayOfVertices[i].setKey(Integer.MAX_VALUE);
        }

        arrayOfVertices[root].setKey(0);

        PriorityQueue<Vertex> queue = new PriorityQueue<>(numberOfVertices);
        Collections.addAll(queue, arrayOfVertices);

        while(!queue.isEmpty())
        {
            Vertex u = queue.poll();
            if(u.getParent() != null)
                listOfEdges.add(new Edge(u.getParent(), u, u.getWeight()));


            for(Vertex neighbour : adjacencyList[u.getIndex()])
            {
                if(queue.contains(neighbour) && neighbour.getWeight() < arrayOfVertices[neighbour.getIndex()].getKey())
                {
                    arrayOfVertices[neighbour.getIndex()].setKey(neighbour.getWeight());
                    arrayOfVertices[neighbour.getIndex()].setParent(u);

                    queue.remove(neighbour);
                    neighbour.setKey(arrayOfVertices[neighbour.getIndex()].getKey());
                    neighbour.setParent(arrayOfVertices[neighbour.getIndex()].getParent());
                    queue.add(neighbour);

                }
            }
        }

        printListOfEdges();
    }

    public void findShortestPaths(int source) {


        for(int i=0; i<numberOfVertices; i++)
        {
            arrayOfVertices[i] = new Vertex(i);
            arrayOfVertices[i].setKey(Integer.MAX_VALUE);
        }

        arrayOfVertices[source].setKey(0);

        PriorityQueue<Vertex> queue = new PriorityQueue<>(numberOfVertices);
        Collections.addAll(queue, arrayOfVertices);
        LinkedList<Vertex> set = new LinkedList<>();

        while(!queue.isEmpty())
        {
            Vertex u = queue.poll();
            set.add(u);

            for(Vertex neighbour : adjacencyList[u.getIndex()])
                relax(u, neighbour, queue);
        }

        printShortestPaths(source);

    }

    public void printShortestPaths(int sourceIndex) {

        Stack stack = new Stack();
        int destinationIndex;

        for(int i=0; i<numberOfVertices; i++)
        {
            destinationIndex = i;
            System.out.println("Shortest Path from Vertex " + sourceIndex + " to Vertex " + destinationIndex);

            while(arrayOfVertices[destinationIndex] != null)
            {
                stack.push(arrayOfVertices[destinationIndex]);
                arrayOfVertices[destinationIndex] = arrayOfVertices[destinationIndex].getParent();
            }

            int fullStack = stack.size();
            Vertex vertex;
            int key=0;

            while(!stack.isEmpty())
            {
                vertex = (Vertex)stack.pop();
                key = vertex.getKey();

                if(stack.size() == fullStack-1) {
                    System.out.print(vertex.getIndex());
                }
                else {
                    System.out.print( " --(" + (key-vertex.getParent().getKey()) + ")--> " + vertex.getIndex());

                }
            }
            System.out.println("\nTotal Distance = " + key);
        }
    }

    private void relax(Vertex u, Vertex neighbour, PriorityQueue queue) {

        if(arrayOfVertices[u.getIndex()].getKey() + neighbour.getWeight() < arrayOfVertices[neighbour.getIndex()].getKey())
        {
            arrayOfVertices[neighbour.getIndex()].setKey(arrayOfVertices[u.getIndex()].getKey() + neighbour.getWeight());
            arrayOfVertices[neighbour.getIndex()].setParent(u);

            queue.remove(neighbour);
            neighbour.setKey(arrayOfVertices[u.getIndex()].getKey() + neighbour.getWeight());
            neighbour.setParent(u);
            queue.add(neighbour);
        }
    }

    public void addEdge(int indexU, int indexV, int weight) {

        adjacencyList[indexU].add(new Vertex(indexV, weight));

        if(!isDirected())
            adjacencyList[indexV].add(new Vertex(indexU, weight));

    }

    public void printGraph() {

        System.out.println("Printing Graph...");

        for(int i=0; i<numberOfVertices; i++)
        {
            System.out.println(i + " ---> ");
            for(Vertex vertex : adjacencyList[i])
            {
                System.out.println("\t\tVertex: " + vertex.getIndex() + "\t Weight: " + vertex.getWeight());
            }
            System.out.println();
        }

        System.out.println();
    }

    private void printArrayOfVertices() {
        for(int i=0; i<numberOfVertices; i++)
        {
            System.out.println("Vertex: " + arrayOfVertices[i].getIndex() + "\t\t" + "Index: " + arrayOfVertices[i].getKey());
        }
    }

    public void printListOfEdges() {

        System.out.println("Printing Prim's Minimum Spanning Tree (Root = 0)\n");

        for(int i=0; i<listOfEdges.size(); i++)
        {
            System.out.println(listOfEdges.get(i).toString());
        }
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public LinkedList<Vertex>[] getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(LinkedList<Vertex>[] adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public void setNumberOfVertices(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }

}
