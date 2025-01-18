import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    private Map<Integer , List<Integer>> adjList;

    public Main(){
        this.adjList = new HashMap<>();
    }

    public void addVertix(int vertex){
        adjList.put(vertex , new LinkedList<>());
    }

    public void removeVertex(int vertex){
        adjList.remove(vertex);

        for(List<Integer> neighbors : adjList.values()){
            neighbors.remove((Integer) vertex);
        }
    }

    public void addEdges(int source , int destination){
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public void removeEdges(int source , int destination){
        adjList.get(source).remove((Integer) destination);
        adjList.get(destination).remove((Integer) destination);
    }

    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    public static void main(String[] args) {

        Main Graph = new Main();

        Graph.addVertix(1);
        Graph.addVertix(2);
        Graph.addVertix(3);
        Graph.addVertix(4);
        Graph.addVertix(5);

        Graph.addEdges(1, 2);
        Graph.addEdges(2, 3);
        Graph.addEdges(3, 4);
        Graph.addEdges(4, 5);
        Graph.addEdges(5, 1);

        Graph.printGraph();

    }


}