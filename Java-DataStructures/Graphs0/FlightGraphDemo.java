import java.util.List;

public class FlightsGraphDemo {
   public static void main(String[] args) {
      // Create a new Graph object
      Graph graph1 = new Graph();
      
      // Add vertices and edges representing plane flights
      Vertex vertexA = graph1.addVertex("Tokyo");
      Vertex vertexB = graph1.addVertex("New York");
      Vertex vertexC = graph1.addVertex("London");
      Vertex vertexD = graph1.addVertex("Sydney");
      graph1.addUndirectedEdge(vertexA, vertexB, 6743);
      graph1.addUndirectedEdge(vertexA, vertexC, 5941);
      graph1.addUndirectedEdge(vertexA, vertexD, 4863);
      graph1.addUndirectedEdge(vertexB, vertexC, 3425);
      graph1.addUndirectedEdge(vertexB, vertexD, 9868);
      graph1.addUndirectedEdge(vertexC, vertexD, 10562);
      
      // Show the graph's vertices and edges
      for (Vertex vertex : graph1.getVertices()) {
         System.out.println("Location: " + vertex.label);
         
         // Show outgoing edges (flights from location)
         System.out.printf("  Flights from %s:%n", vertex.label);
         for (Edge outgoingEdge : graph1.getEdgesFrom(vertex)) {
            System.out.printf(
               "   - %s to %s, %d miles%n", 
               vertex.label,
               outgoingEdge.toVertex.label, 
               (int)outgoingEdge.weight);
         }
         
         // Show incoming edges (flights to location)
         System.out.printf("  Flights to %s:%n", vertex.label);
         for (Edge incomingEdge : graph1.getEdgesTo(vertex)) {
            System.out.printf(
               "   - %s to %s, %d miles%n", 
               incomingEdge.fromVertex.label, 
               vertex.label,
               (int)incomingEdge.weight);
         }
      }
   }
}
