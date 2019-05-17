public class Vertex implements Comparable<Vertex> {

    private int index;
    private int weight;
    private int key;
    private Vertex parent;
    private String label;

    public Vertex(int index) {
        this.index = index;
    }

    public Vertex(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    public int getValue() {
        return weight;
    }

    public void setValue(int value) {
        this.weight = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }


    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    @Override
    public int compareTo(Vertex o) {
        if(o.getKey() < this.key)
            return 1;
        else if(o.getKey() == this.key)
            return 0;
        else
            return -1;

    }

    @Override
    public boolean equals(Object obj) {
        Vertex vertex = (Vertex) obj;
        return (vertex.getIndex() == this.index);
    }
}
