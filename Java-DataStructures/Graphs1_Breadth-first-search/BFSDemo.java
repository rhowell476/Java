import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFSDemo {
   public static List<Vertex> breadthFirstSearch(Graph graph, Vertex startVertex) {
      return breadthFirstSearch(graph, startVertex, new HashMap<Vertex, Double>()); 
   }
   
   public static List<Vertex> breadthFirstSearch(Graph graph, Vertex startVertex, HashMap<Vertex, Double> distances) {
      HashSet<Vertex> discoveredSet = new HashSet<Vertex>();
      Queue<Vertex> frontierQueue = new LinkedList<Vertex>();
      ArrayList<Vertex> visitedList = new ArrayList<Vertex>();
    
      // startVertex has a distance of 0 from itself
      distances.put(startVertex, 0.0);

      frontierQueue.add(startVertex); // Enqueue startVertex in frontierQueue
      discoveredSet.add(startVertex); // Add startVertex to discoveredSet

      while (frontierQueue.size() > 0) {
         Vertex currentVertex = frontierQueue.remove();
         visitedList.add(currentVertex);
         for (Edge edge : graph.getEdgesFrom(currentVertex)) {
            Vertex adjacentVertex = edge.toVertex;
            if (!discoveredSet.contains(adjacentVertex)) {
               frontierQueue.add(adjacentVertex);
               discoveredSet.add(adjacentVertex);
                
               // Distance of adjacentVertex is 1 more than currentVertex
               distances.put(adjacentVertex, distances.get(currentVertex) + 1);
            }
         }
      }
      return visitedList;
   }

   public static void main(String[] args) {
      Graph peopleGraph = new Graph();
      Vertex vertexA = peopleGraph.addVertex("Joe");
      Vertex vertexB = peopleGraph.addVertex("Eva");
      Vertex vertexC = peopleGraph.addVertex("Taj");
      Vertex vertexD = peopleGraph.addVertex("Chen");
      Vertex vertexE = peopleGraph.addVertex("Lily");
      Vertex vertexF = peopleGraph.addVertex("Jun");
      Vertex vertexG = peopleGraph.addVertex("Ken");
      
      // Add graph edges
      peopleGraph.addUndirectedEdge(vertexA, vertexB);  // Edge from Joe to Eva
      peopleGraph.addUndirectedEdge(vertexA, vertexC);  // Edge from Joe to Taj
      peopleGraph.addUndirectedEdge(vertexB, vertexE);  // Edge from Eva to Lily
      peopleGraph.addUndirectedEdge(vertexC, vertexD);  // Edge from Taj to Chen
      peopleGraph.addUndirectedEdge(vertexC, vertexE);  // Edge from Taj to Lily
      peopleGraph.addUndirectedEdge(vertexD, vertexF);  // Edge from Chen to Jun
      peopleGraph.addUndirectedEdge(vertexE, vertexF);  // Edge from Lily to Jun
      peopleGraph.addUndirectedEdge(vertexF, vertexG);  // Edge from Jun to Ken
      
      // Ask the user for the starting person's name
      Scanner scnr = new Scanner(System.in);
      System.out.print("Enter the starting person's name: ");
      String startName = scnr.nextLine();
      System.out.println();
      
      // Search for the start vertex
      Vertex startVertex = null;
      for (Vertex vertex : peopleGraph.getVertices()) {
          if (startName.equals(vertex.label)) {
             startVertex = vertex;
          }
      }
      
      if (startVertex == null) {
         System.out.printf("Start vertex \"%s\" not found%n", startName);
      }
      else {
         HashMap<Vertex, Double> vertexDistances = new HashMap<Vertex, Double>();
         List<Vertex> visitedList = breadthFirstSearch(peopleGraph, startVertex, vertexDistances);
         
         // Output the result
         System.out.println("Breadth-first search traversal");
         System.out.printf("Start vertex: %s%n", startVertex.label);
         for (Vertex vertex : visitedList) {
            System.out.println(vertex.label + ": " + vertexDistances.get(vertex).intValue());
         }
      }
   }
}
