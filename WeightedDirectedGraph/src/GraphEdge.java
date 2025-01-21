public class GraphEdge {

    private final int source;
    private final int destination;
    private final int weight;

    public GraphEdge(int source , int  destination , int weight){
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "(" + source + " -> " + destination + ", weight: " + weight + ")";
    }
}
