import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class AllPairsShortestPathDemo {
   // Implementation of Floyd-Warshall all-pairs shortest path
   public static double[][] allPairsShortestPath(List<Vertex> vertices,
      List<Edge> edges) {
      int numVertices = vertices.size();
      
      // Initialize distMatrix to a numVertices x numVertices matrix
      // with all values set to infinity
      double[][] distMatrix = new double[numVertices][numVertices];
      for (int i = 0; i < numVertices; i++) {
         for (int j = 0; j < numVertices; j++) {
            distMatrix[i][j] = Double.POSITIVE_INFINITY;
         }
      }
      
      // Set each distance for vertex to same vertex to 0
      for (int i = 0; i < numVertices; i++) {
         distMatrix[i][i] = 0.0;
      }
      
      // Finish matrix initialization
      for (Edge edge : edges) {
         int index1 = vertices.indexOf(edge.fromVertex);
         int index2 = vertices.indexOf(edge.toVertex);
         distMatrix[index1][index2] = edge.weight;
      }
      
      // Loop through vertices
      for (int k = 0; k < numVertices; k++) {
         for (int toIndex = 0; toIndex < numVertices; toIndex++) {
            for (int fromIndex = 0; fromIndex < numVertices; fromIndex++) {
               double currentLength = distMatrix[fromIndex][toIndex];
               double possibleLength = distMatrix[fromIndex][k] + distMatrix[k][toIndex];
               if (possibleLength < currentLength) {
                  distMatrix[fromIndex][toIndex] = possibleLength;
               }
            }
         }
      }

      return distMatrix;
   }
   
   public static void displayMatrix(double[][] matrix, List<Vertex> vertices) {
      // This method assumes a simple square matrix, where each entry is either 
      // an integer in the range [-99, 99], or infinity. Each vertex's label is 
      // also assumed to be a single character.
      
      // First print column headers
      System.out.printf("   ");
      for (int entryIndex = 0; entryIndex < matrix.length; entryIndex++) {
         System.out.printf("  %s ", vertices.get(entryIndex).label);
      }
      System.out.println();
      
      for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
         System.out.printf("%s [ ", vertices.get(rowIndex).label);
         for (int entryIndex = 0; entryIndex < matrix.length; entryIndex++) {
            double entry = matrix[rowIndex][entryIndex];
            
            // Case 1: entry is infinity
            if (Double.isInfinite(entry)) {
               System.out.print("inf ");
            }
            
            // Case 2: entry is negative
            else if (entry < 0) {
               // Case 2A: entry is > -10
               if (entry > -10) {
                  System.out.printf("%d  ", (int)entry);
               }
               // Case 2B: entry is <= -10
               else {
                  System.out.printf("%d ", (int)entry);
               }
            }
            
            // Case 3: entry is non-negative
            else {
               // Case 3A: entry is < 10
               if (entry < 10) {
                  System.out.printf(" %d  ", (int)entry);
               }
               // Case 3B: entry is >= 10
               else {
                  System.out.printf(" %d ", (int)entry);
               }
            }
         }
         System.out.println("]");
      }
   }
   
   // Path reconstruction method
   public static List<Edge> reconstructPath(Graph graph, List<Vertex> vertices, 
      Vertex startVertex, Vertex endVertex, double[][] distMatrix) {
      int startIndex = vertices.indexOf(startVertex);
      ArrayList<Edge> path = new ArrayList<Edge>();
      
      // Backtrack from the ending vertex
      int currentIndex = vertices.indexOf(endVertex);
      while (currentIndex != startIndex) {
         Collection<Edge> incomingEdges = graph.getEdgesTo(vertices.get(currentIndex));
         
         boolean foundNext = false;
         for (Edge currentEdge : incomingEdges) {
            double expected = distMatrix[startIndex][currentIndex] - currentEdge.weight;
            double actual = distMatrix[startIndex][vertices.indexOf(currentEdge.fromVertex)];
            if (expected == actual) {
               // Update current vertex index
               currentIndex = vertices.indexOf(currentEdge.fromVertex);
                
               // Prepend currentEdge to path
               path.add(0, currentEdge);
                
               // The next vertex in the path was found
               foundNext = true;
                
               // The correct incoming edge was found, so break the inner loop
               break;
            }
         }
         
         if (!foundNext) {
            return null;
         }
      }

      return path;
   }
    
   public static void main(String[] args) {
      String[] graphVertices = { "A,B,C,D", "A,B,C,D", "A,B,C", "A,B,C,D,E" };
      String[] graphEdges = {
         "AB2,BC-3,BD7,CA5,DA-4",
         "AB4,BC3,CD6,DA-1,DB7",
         "AB1,AC1,BC-8",
         "AB1,AE8,BC2,CD3,DA-5,ED9"
      };
      String[] graphPaths = {
         "CD", // Show path from C to D in graph 1
         "DB", // Show path from D to B in graph 2
         "CA", // Show path from C to A in graph 3
         "AD"  // Show path from A to D in graph 4
      };
      
      // Build each graph and the all pairs shortest path matrix for each
      for (int graphNum = 1; graphNum <= graphVertices.length; graphNum++) {
         // Create a new graph
         Graph graph = new Graph();
         
         // Create and add vertices to the graph and an ArrayList
         ArrayList<Vertex> vertices = new ArrayList<Vertex>();
         for (String vertexName : graphVertices[graphNum - 1].split(",")) {
            vertices.add(graph.addVertex(vertexName));
         }
         
         // Parse and add edges
         String edgesString = graphEdges[graphNum - 1];
         for (String edgeString : edgesString.split(",")) {
            Vertex fromVertex = graph.getVertex(edgeString.substring(0, 1));
            Vertex toVertex = graph.getVertex(edgeString.substring(1, 2));
            double weight = Double.parseDouble(edgeString.substring(2));
            graph.addDirectedEdge(fromVertex, toVertex, weight);
         }
         
         // Get the all pairs shortest path matrix
         ArrayList<Edge> allEdges = new ArrayList<Edge>(graph.getEdges());
         double[][] matrix = allPairsShortestPath(vertices, allEdges);
         
         // Display the matrix
         System.out.printf("All pairs shortest path matrix (graph %d):%n", graphNum);
         displayMatrix(matrix, vertices);
         
         // Show an actual path sequence
         String startVertexLabel = graphPaths[graphNum - 1].substring(0, 1);
         String endVertexLabel = graphPaths[graphNum - 1].substring(1, 2);
         System.out.printf("Shortest path from %s to %s:%n",
            startVertexLabel, endVertexLabel);
         Vertex startVertex = graph.getVertex(startVertexLabel);
         Vertex endVertex = graph.getVertex(endVertexLabel);
         List<Edge> path = reconstructPath(graph, vertices, startVertex, endVertex, matrix);
         if (path == null || path.size() == 0) {
            System.out.println("No path");
         }
         else {
            System.out.print(path.get(0).fromVertex.label);
            for (Edge edge : path) {
               System.out.print(" to " + edge.toVertex.label);
            }
            System.out.println();
         }
         System.out.println();
      }
   }
}