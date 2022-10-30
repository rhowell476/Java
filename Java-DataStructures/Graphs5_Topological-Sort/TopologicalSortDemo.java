import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TopologicalSortDemo {
   public static int getIncomingEdgeCount(Collection<Edge> edgeList, Vertex vertex) {
      int count = 0;
      for (Edge edge : edgeList) {
         if (edge.toVertex == vertex) {
            count++;
         }
      }
      return count;
   }
   
   public static List<Vertex> topologicalSort(Graph graph) {
      // Get a collection of all the graph's edges
      Collection<Edge> allEdges = graph.getEdges();
      
      // Make a list of vertices with no incoming edges
      ArrayList<Vertex> noIncoming = new ArrayList<Vertex>();
      for (Vertex vertex : graph.getVertices()) {
         if (getIncomingEdgeCount(allEdges, vertex) == 0) {
            noIncoming.add(vertex);
         }
      }
      
      // Initialize the result list
      ArrayList<Vertex> resultList = new ArrayList<Vertex>();
      
      // remainingEdges starts with all edges in the graph
      HashSet<Edge> remainingEdges = new HashSet<Edge>(allEdges);
      while (noIncoming.size() > 0) {
         // Select the next vertex for the final result
         Vertex currentVertex = noIncoming.remove(noIncoming.size() - 1);
         resultList.add(currentVertex);
         System.out.printf("\nresultList is: %s", currentVertex.label);
         
         // Make a list of all edges from remainingEdges that are outgoing from 
         // currentVertex
         ArrayList<Edge> outgoingEdges = new ArrayList<Edge>();
         for (Edge edge : remainingEdges) {
            if (edge.fromVertex == currentVertex) {
               outgoingEdges.add(edge);
            }
         }
         
         // Remove currentVertex's outgoing edges from remainingEdges
         remainingEdges.removeAll(outgoingEdges);
         
         // Check for new vertices with no incoming edges
         for (Edge edge : outgoingEdges) {
            if (getIncomingEdgeCount(remainingEdges, edge.toVertex) == 0) {
               noIncoming.add(edge.toVertex);
            }
         }
      }
      
      return resultList;
   }

   public static void main(String[] args) {
      // Make 2 graphs
      Graph graph1 = new Graph();
      Vertex vertexA = graph1.addVertex("A");
      Vertex vertexB = graph1.addVertex("B");
      Vertex vertexC = graph1.addVertex("C");
      Vertex vertexD = graph1.addVertex("D");
      Vertex vertexE = graph1.addVertex("E");
      Vertex vertexF = graph1.addVertex("F");
      Vertex vertexG = graph1.addVertex("G");
      graph1.addDirectedEdge(vertexA, vertexB);
      graph1.addDirectedEdge(vertexA, vertexC);
      graph1.addDirectedEdge(vertexB, vertexF);
      graph1.addDirectedEdge(vertexC, vertexD);
      graph1.addDirectedEdge(vertexD, vertexF);
      graph1.addDirectedEdge(vertexE, vertexG);
      graph1.addDirectedEdge(vertexE, vertexF);
      graph1.addDirectedEdge(vertexF, vertexG);
      
      // Graph graph2 = new Graph();
      // vertexA = graph2.addVertex("A");
      // vertexB = graph2.addVertex("B");
      // vertexC = graph2.addVertex("C");
      // vertexD = graph2.addVertex("D");
      // vertexE = graph2.addVertex("E");
      // vertexF = graph2.addVertex("F");
      // vertexG = graph2.addVertex("G");
      // graph2.addDirectedEdge(vertexA, vertexE);
      // graph2.addDirectedEdge(vertexB, vertexC);
      // graph2.addDirectedEdge(vertexC, vertexF);
      // graph2.addDirectedEdge(vertexC, vertexG);
      // graph2.addDirectedEdge(vertexD, vertexA);
      // graph2.addDirectedEdge(vertexD, vertexB);
      // graph2.addDirectedEdge(vertexE, vertexG);
      // graph2.addDirectedEdge(vertexF, vertexG);
      
      // Do a topological sort on each graph
      Graph[] graphs = { graph1 };
      int graphNum = 1;
      for (Graph graph : graphs) {
         List<Vertex> resultList = topologicalSort(graph);
      
         // Display the sorted results
         System.out.printf("Graph %d: ", graphNum);
         if (resultList.size() > 0) {
            System.out.print(resultList.get(0).label);
         }
         for (int i = 1; i < resultList.size(); i++) {
            System.out.printf(" -> %s", resultList.get(i).label);
         }
         System.out.println();
         graphNum++;
      }
   }
}
