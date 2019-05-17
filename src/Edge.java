public class Edge {

    private Vertex u;
    private Vertex v;
    private int weight;

    public Edge(Vertex u, Vertex v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public Vertex getU() {
        return u;
    }

    public void setU(Vertex u) {
        this.u = u;
    }

    public Vertex getV() {
        return v;
    }

    public void setV(Vertex v) {
        this.v = v;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        int indexU = this.u.getIndex();
        int indexV = this.v.getIndex();
        return indexU + " --(" + this.weight + ")-->" + " " + indexV;
    }
}
