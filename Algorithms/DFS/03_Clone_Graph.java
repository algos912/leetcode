// https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1392/
// https://www.programcreek.com/2012/12/leetcode-clone-graph-java/

// Given a reference of a node in a connected undirected graph. Return a deep copy (clone) of the graph.

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        // check for invalid inputs
        if(node == null)
            return node;
        
        map.put(node, new Node(node.val, new ArrayList<>()));
        
        for(Node neighbor : node.neighbors) {
            if(map.containsKey(neighbor)) {
                map.get(node).neighbors.add(map.get(neighbor));
            } else {
                map.get(node).neighbors.add(cloneGraph(neighbor));
            }
        }
        
        return map.get(node); 
    }
}
