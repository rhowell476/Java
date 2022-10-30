import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class EdgeComparator implements Comparator<Edge> {
   public int compare(Edge edge1, Edge edge2) {
      if (edge1.weight > edge2.weight) {
         return 1;
      }
      else if (edge1.weight < edge2.weight) {
         return -1;
      }
      return 0;
   }
}

public class MinimumSpanningTreeDemo {
   // Returns a list of edges representing the graph's minimum spanning tree.
   // Uses Kruskal's minimum spanning tree algorithm.
   public static List<Edge> minimumSpanningTree(Graph graph) {
      // Get a collection of the graph's edges
      Collection<Edge> allEdges = graph.getEdges();
       
      // edgeQueue starts as a priority queue of all edges from the graph
      PriorityQueue<Edge> edgeQueue;
      edgeQueue = new PriorityQueue<Edge>(allEdges.size(), new EdgeComparator());
      edgeQueue.addAll(allEdges);
      
      // Initialize the collection of vertex sets
      VertexSetCollection vertexSets = new VertexSetCollection(graph.getVertices());
      
      // resultList is initially an empty list
      ArrayList<Edge> resultList = new ArrayList<Edge>();
      
      while (edgeQueue.size() > 0) {
         // Remove edge with minimum weight from edgeQueue
         Edge nextEdge = edgeQueue.remove();
         
         // set1 = set in vertexSets containing nextEdge's 'from' vertex
         HashSet<Vertex> set1 = vertexSets.getSet(nextEdge.fromVertex);
         // set2 = set in vertexSets containing nextEdge's 'to' vertex
         HashSet<Vertex> set2 = vertexSets.getSet(nextEdge.toVertex);
         
         // If the 2 sets are distinct, then merge
         if (set1 != set2) {
            // Add nextEdge to resultList
            resultList.add(nextEdge);
            // Merge the 2 sets within the collection
            vertexSets.merge(set1, set2);
         }
      }
      
      return resultList;
   }
    
   public static void main(String[] args) {
      // Add vertices A through H to graph1
      Graph graph1 = new Graph();
      String[] vertexNames = { "A", "B", "C", "D", "E", "F", "G", "H" };
      for (String vertexName : vertexNames) {
         graph1.addVertex(vertexName);
      }

      // Add graph1's edges
      graph1.addDirectedEdge(graph1.getVertex("A"), graph1.getVertex("D"), 20);
      graph1.addDirectedEdge(graph1.getVertex("A"), graph1.getVertex("G"), 12);
      graph1.addDirectedEdge(graph1.getVertex("B"), graph1.getVertex("G"), 12);
      graph1.addDirectedEdge(graph1.getVertex("B"), graph1.getVertex("F"), 16);
      graph1.addUndirectedEdge(graph1.getVertex("B"), graph1.getVertex("D"), 15);
      graph1.addUndirectedEdge(graph1.getVertex("B"), graph1.getVertex("C"), 10);
      graph1.addDirectedEdge(graph1.getVertex("C"), graph1.getVertex("F"), 15);
      graph1.addDirectedEdge(graph1.getVertex("D"), graph1.getVertex("G"), 15);
      graph1.addDirectedEdge(graph1.getVertex("D"), graph1.getVertex("E"), 12);
      graph1.addDirectedEdge(graph1.getVertex("E"), graph1.getVertex("F"), 10);
      graph1.addDirectedEdge(graph1.getVertex("F"), graph1.getVertex("G"), 14);


      
      // Add vertices A through G, and P, to graph2
      Graph graph2 = new Graph();
      String[] vertexNames2 = { "A", "B", "C", "D", "E", "F", "G", "P" };
      for (String vertexName : vertexNames2) {
         graph2.addVertex(vertexName);
      }
      
      // Add graph2's edges
      graph2.addUndirectedEdge(graph2.getVertex("A"), graph2.getVertex("B"), 80);
      graph2.addUndirectedEdge(graph2.getVertex("A"), graph2.getVertex("C"), 105);
      graph2.addUndirectedEdge(graph2.getVertex("A"), graph2.getVertex("E"), 182);
      graph2.addUndirectedEdge(graph2.getVertex("B"), graph2.getVertex("C"), 90);
      graph2.addUndirectedEdge(graph2.getVertex("B"), graph2.getVertex("D"), 60);
      graph2.addUndirectedEdge(graph2.getVertex("B"), graph2.getVertex("P"), 100);
      graph2.addUndirectedEdge(graph2.getVertex("C"), graph2.getVertex("P"), 132);
      graph2.addUndirectedEdge(graph2.getVertex("D"), graph2.getVertex("E"), 80);
      graph2.addUndirectedEdge(graph2.getVertex("E"), graph2.getVertex("F"), 70);
      graph2.addUndirectedEdge(graph2.getVertex("F"), graph2.getVertex("G"), 72);
      graph2.addUndirectedEdge(graph2.getVertex("F"), graph2.getVertex("P"), 145);
      graph2.addUndirectedEdge(graph2.getVertex("G"), graph2.getVertex("P"), 180);
      
      // Get the minimum spanning tree for both graphs
      Graph[] graphs = { graph1 };
      int graphNum = 1;
      for (Graph graph : graphs) {
         // Get the list of edges for the graph's minimum spanning tree
         List<Edge> treeEdges = minimumSpanningTree(graph);

         // Display the list of edges
         System.out.printf("Edges in minimum spanning tree (graph %d):%n", graphNum);
         for (Edge edge : treeEdges) {
            System.out.print(edge.fromVertex.label + " to " + edge.toVertex.label);
            System.out.printf(", weight = %d%n", (int)edge.weight);
         }
         
         graphNum++;
      }
   }
}