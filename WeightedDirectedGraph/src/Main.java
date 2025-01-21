import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    private int vertices;
    private List<GraphEdge>[] adjList;

    public Main(int vertices){
        this.vertices = vertices;
        adjList = new ArrayList[vertices];

        for(int i=0;i<vertices;i++){
            adjList[i] = new ArrayList<>();
        }
    }

    public void addDirectedEdges(int source , int destination , int weight){
        GraphEdge edge = new GraphEdge(source,destination,weight);

        adjList[source].add(edge);
    }

    public void addUndirectedEdge(int source , int destination , int weight){
        GraphEdge sourceToDestinationEdge = new GraphEdge(source , destination , weight);
        GraphEdge destinationToSourceEdge = new GraphEdge(destination , source , weight);

        adjList[source].add(sourceToDestinationEdge);
        adjList[destination].add(destinationToSourceEdge);
    }

    public void removeDirectedEdge(int source , int destination , int weight){
        Iterator<GraphEdge> iterator = adjList[source].iterator();

        while(!iterator.hasNext()){
            GraphEdge edge = iterator.next();
            if (edge.getDestination() == destination && edge.getWeight() == weight){
                iterator.remove();
                break;
            }
        }
    }

    public void removeUndirectedEdge(int source , int destination , int weight){
        removeDirectedEdge(source,destination,weight);
        removeDirectedEdge(destination,source,weight);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (GraphEdge edge : adjList[i]) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
            Main graph = new Main(6);

            graph.addDirectedEdges(1,2,16);
            graph.addDirectedEdges(2,3,19);
            graph.addUndirectedEdge(3,4,20);
            graph.addUndirectedEdge(4,5,25);

            graph.printGraph();

    }
}