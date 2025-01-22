import java.util.ArrayList;
import java.util.List;

public class Node {
    private int value;
    private List<Node> neighbors;

    public Node(int value){
        this.value = value;
        neighbors = new ArrayList<>();
    }

    public Node(int value , List<Node> neighbors){
        this.value = value;
        this.neighbors = neighbors;
    }

    public int getValue() {
        return value;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }
}
