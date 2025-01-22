import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.getNeighbors().add(node2);
        node1.getNeighbors().add(node4);
        node2.getNeighbors().add(node1);
        node2.getNeighbors().add(node3);
        node3.getNeighbors().add(node2);
        node3.getNeighbors().add(node4);
        node4.getNeighbors().add(node1);
        node4.getNeighbors().add(node3);

        System.out.println("Original Graph");
        printGraph(node1, new HashSet<>());

        Solution solution = new Solution();
        Node clonedNode = solution.cloneGraph(node1);

        System.out.println("\nCloned Graph");
        printGraph(clonedNode, new HashSet<>());
    }

    private static void printGraph(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);

        System.out.print("Node " + node.getValue() + " neighbors: ");
        for (Node neighbor : node.getNeighbors()) {
            System.out.print(neighbor.getValue() + " ");
        }
        System.out.println();

        for (Node neighbor : node.getNeighbors()) {
            printGraph(neighbor, visited);
        }
    }
}