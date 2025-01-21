import java.util.*;

public class Main {

    Map<Integer, List<Integer>> adjList;

    public Main(){
        adjList = new HashMap<>();
    }

    public void addVertex(int v){
        adjList.put(v,new LinkedList<>());
    }

    public void removeVertex(int v){
        adjList.remove((Integer)v);

        for(List<Integer> neighbor : adjList.values()){
            neighbor.remove((Integer) v);
        }
    }

    public void addEdges(int source , int destination){
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public void removeEdges(int source , int destination){
        adjList.get(source).remove((Integer) destination);
        adjList.get(destination).remove((Integer) source);
    }

    public void printGraph(){
        for(Map.Entry<Integer , List<Integer>> map : adjList.entrySet()){
            int key = map.getKey();
            List<Integer> values = map.getValue();
            System.out.println(key + " " + values);
        }
    }

    public void BFS(int v){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);


        while(!queue.isEmpty()){

            int currentVertex = queue.poll();
            System.out.println(currentVertex);
            visited.add(currentVertex);

            for(int vertex : adjList.get(currentVertex)){
                if(!visited.contains(vertex)){
                    queue.add(vertex);
                    visited.add(vertex);
                }
            }
        }

    }
    public static void main(String[] args) {
        Main graph = new Main();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdges(1,2);
        graph.addEdges(1,3);
        graph.addEdges(3,2);
        graph.addEdges(3,5);
        graph.addEdges(4,5);

        graph.printGraph();

        graph.BFS(5);
    }
}