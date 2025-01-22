import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node cloneGraph(Node node){
        Map<Node , Node> map = new HashMap<>();
        return newClonedGraph(node , map);
    }

    private Node newClonedGraph(Node node , Map<Node , Node> map){
       Node newNode = new Node(node.getValue());
       map.put(node , newNode);

       for(Node neighbor : node.getNeighbors()){
           if(!map.containsKey(neighbor)){
               newNode.getNeighbors().add(newClonedGraph(neighbor , map));
           }else {
               newNode.getNeighbors().add(map.get(neighbor));
           }
       }
       return newNode;
    }
}
