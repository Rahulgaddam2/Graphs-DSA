// To perform DFS we need two additional data structures
// 1. Sets
// 2. stack

import java.util.*;

public class Main {

    Map<Integer , List<Integer>> adjList;

    public Main(){
        adjList = new HashMap<>();
    }

    public void addVertex(int v){
        adjList.put(v , new LinkedList<>());
    }

    public void removeVertex(int v){
        adjList.remove((Integer) v);

        for(List<Integer> neighbors : adjList.values()){
            neighbors.remove((Integer) v);
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
            System.out.println("Vertex : " + key + " " + " edges : " + values);
        }
    }

    public void DFS(int v){
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(v);
        visited.add(v);

        while(!stack.isEmpty()){

            int currentVertex = stack.pop();
            visited.add(currentVertex);
            System.out.println(currentVertex + " ");



            for(int neighbor : adjList.get(currentVertex)){
                if(!visited.contains(neighbor)){
                    stack.push(neighbor);
                    visited.add(neighbor);
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

            graph.DFS(1);


    }
}