import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DFSDemo {
   public static void depthFirstSearch(Graph graph, Vertex startVertex, VertexVisitor visitor) {
      Stack<Vertex> vertexStack = new Stack<Vertex>();
      HashSet<Vertex> visitedSet = new HashSet<Vertex>();
      
      vertexStack.push(startVertex);
      
      while (vertexStack.size() > 0) {
         Vertex currentVertex = vertexStack.pop();
         if (!visitedSet.contains(currentVertex)) {
            visitor.visit(currentVertex);
            visitedSet.add(currentVertex);
            for (Edge edge : graph.getEdgesFrom(currentVertex)) {
               Vertex adjacentVertex = edge.toVertex;
               vertexStack.push(adjacentVertex);
            }
         }
      }
   }

   public static void main(String[] args) {
      // Main program - Creates 3 different graphs, each with vertices A through F, but with 
      // different sets of edges. Traverses each with DFS.
      String[] vertexNames = { "A", "B", "C", "D", "E", "F" };
      
      // Add the same set of vertices to 3 different graphs
      Graph graph1 = new Graph();
      Graph graph2 = new Graph();
      Graph graph3 = new Graph();
      Graph[] graphs = { graph1, graph2, graph3 };
      for (String vertexName : vertexNames) {
         for (Graph graph : graphs) {
            graph.addVertex(vertexName);
         }
      }
      
      // Add graph 1's edges
      graph1.addUndirectedEdge(graph1.getVertex("A"), graph1.getVertex("B"));
      graph1.addUndirectedEdge(graph1.getVertex("A"), graph1.getVertex("D"));
      graph1.addUndirectedEdge(graph1.getVertex("B"), graph1.getVertex("E"));
      graph1.addUndirectedEdge(graph1.getVertex("B"), graph1.getVertex("F"));
      graph1.addUndirectedEdge(graph1.getVertex("C"), graph1.getVertex("F"));
      graph1.addUndirectedEdge(graph1.getVertex("E"), graph1.getVertex("F"));
      
      // Add graph 2's edges
      graph2.addUndirectedEdge(graph2.getVertex("A"), graph2.getVertex("B"));
      graph2.addUndirectedEdge(graph2.getVertex("B"), graph2.getVertex("C"));
      graph2.addUndirectedEdge(graph2.getVertex("C"), graph2.getVertex("F"));
      graph2.addUndirectedEdge(graph2.getVertex("D"), graph2.getVertex("E"));
      graph2.addUndirectedEdge(graph2.getVertex("E"), graph2.getVertex("F"));

      // Add graph 3's edges
      graph3.addUndirectedEdge(graph3.getVertex("A"), graph3.getVertex("B"));
      graph3.addUndirectedEdge(graph3.getVertex("A"), graph3.getVertex("E"));
      graph3.addUndirectedEdge(graph3.getVertex("B"), graph3.getVertex("C"));
      graph3.addUndirectedEdge(graph3.getVertex("B"), graph3.getVertex("E"));
      graph3.addUndirectedEdge(graph3.getVertex("C"), graph3.getVertex("E"));
      graph3.addUndirectedEdge(graph3.getVertex("D"), graph3.getVertex("E"));
      graph3.addUndirectedEdge(graph3.getVertex("E"), graph3.getVertex("F"));

      // Create the visitor that displays a vertex's label
      VertexVisitor visitor = new PrintVisitor();

      // Choose a starting vertex
      String startVertexLabel = "A";

      // Visit vertices in each graph with DFS
      System.out.println("Depth-first search traversal");
      for (int i = 0; i < graphs.length; i++) {
         System.out.printf("Graph %d: ", i + 1);
         Vertex startVertex = graphs[i].getVertex(startVertexLabel);
         depthFirstSearch(graphs[i], startVertex, visitor);
         System.out.println();
      }
   }
}