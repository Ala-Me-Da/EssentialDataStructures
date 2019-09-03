import java.util.*;

public class Graph<E> {

    class Node {
        E element;
        String name;
        boolean visited;

        Node(String name, E elem, boolean v) {
            this.element = elem;
            this.visited = v;
            this.name = name;
        }
    }

    // Adjacency List representation using a Hash Map
    private Map<String, List<Node>> mGraph;

    private Graph() {
        mGraph = new HashMap<>();
    }

    /** 
     * Simple 
     */ 
    public void buildGraph(String[] nodeNames,  E[] elements) {
        Map<String, Node> nodes = new HashMap<String, Node>();
        for(int i = 0; i < nodeNames.length; i++){
            Node node = new Node(nodeNames[i], elements[i], false);
            nodes.put(nodeNames[i], node);
        }

        ArrayList<Node> a1 = new ArrayList<>();
        a1.add(nodes.get("B"));

        ArrayList<Node> a2 = new ArrayList<>();
        a2.add(nodes.get("C"));

        ArrayList<Node> a3 = new ArrayList<>();
        a3.add(nodes.get("D"));
        a3.add(nodes.get("E"));

        ArrayList<Node> a4 = new ArrayList<>();
        a4.add(nodes.get("C"));
        a4.add(nodes.get("E"));

        ArrayList<Node> a5 = new ArrayList<>();
        a5.add(nodes.get("C"));
        a5.add(nodes.get("D"));

        mGraph.put("A", a1);
        mGraph.put("B", a2);
        mGraph.put("C", a3);
        mGraph.put("D", a4);
        mGraph.put("E", a5);
    }

    public void displayGraph() {
            for(char key = 'A'; key <= 'E'; key++) {
                List<Node> children = mGraph.get(key + "");
                System.out.print(key + ": ");
                for(Node c : children) {
                    System.out.print(c.name + " (" + c.element + ")" +  " -->");
                }
		
                System.out.println(" END");
            }
    }

    public static void main(String[] args) {
            Graph<Integer> graph = new Graph<>();
            String[] nodes = new String[] { "A", "B", "C", "D", "E"};
            Integer[] nodeElems = new Integer[] {1, 2, 3, 4, 5};
            graph.buildGraph(nodes, nodeElems);
            graph.displayGraph();
    }
}
