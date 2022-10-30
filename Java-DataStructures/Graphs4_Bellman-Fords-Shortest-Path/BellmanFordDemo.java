import java.util.HashMap;

// Stores information for a vertex that is relevant to a shortest path algorithm
class PathVertexInfo {
   public Vertex vertex;
   public double distance;
   public Vertex predecessor;
   
   public PathVertexInfo(Vertex vertex) {
      this.vertex = vertex;
      distance = Double.POSITIVE_INFINITY;
      predecessor = null;
   }
}

public class BellmanFordDemo {
   public static HashMap<Vertex, PathVertexInfo> bellmanFord(Graph graph, Vertex startVertex) {
      // Initialize a PathVertexInfo object for each vertex. Each PathVertexInfo 
      // object has an infinite distance and null predecessor by default.
      HashMap<Vertex, PathVertexInfo> info;
      info = new HashMap<Vertex, PathVertexInfo>();
      for (Vertex currentVertex : graph.getVertices()) {
         PathVertexInfo currentVertexInfo = new PathVertexInfo(currentVertex);
         info.put(currentVertex, currentVertexInfo);
      }
      
      // startVertex has a distance of 0 from itself
      info.get(startVertex).distance = 0.0;
      
      // Main loop is executed |V|-1 times to guarantee minimum distances
      for (int i = 0; i < info.size() - 1; i++) {
         // The main loop
         for (Vertex currentVertex : graph.getVertices()) {
            for (Edge edge : graph.getEdgesFrom(currentVertex)) {
               Vertex adjacentVertex = edge.toVertex;
               double alternativePathDistance = 
                  info.get(currentVertex).distance + edge.weight;
               
               // If a shorter path from startVertex to adjacentVertex has been 
               // found, update adjacentVertex's distance and predecessor
               PathVertexInfo adjacentInfo = info.get(adjacentVertex);
               if (alternativePathDistance < adjacentInfo.distance) {
                  adjacentInfo.distance = alternativePathDistance;
                  adjacentInfo.predecessor = currentVertex;
               }
            }
         }
      }
      
      // Check for a negative edge weight cycle
      for (Vertex currentVertex : graph.getVertices()) {
         for (Edge edge : graph.getEdgesFrom(currentVertex)) {
            Vertex adjacentVertex = edge.toVertex;
            double alternativePathDistance = 
               info.get(currentVertex).distance + edge.weight;
            
            // If a shorter path from startVertex to adjacentVertex is still 
            // found then a negative edge weight cycle exists
            if (alternativePathDistance < info.get(adjacentVertex).distance) {
               return null;
            }
         }
      }
      
      return info;
   }
   
   public static String getShortestPath(Vertex startVertex, Vertex endVertex, 
      HashMap<Vertex, PathVertexInfo> infoMap) {
      // Start from endVertex and build the path in reverse.
      String path = "";
      Vertex currentVertex = endVertex;
      while (currentVertex != startVertex) {
         path = " -> " + currentVertex.label + path;
         currentVertex = infoMap.get(currentVertex).predecessor;
      }
      path = startVertex.label + path;
      return path;
   }

   public static void main(String[] args) {
      Graph graph = new Graph();
      Vertex vertexA = graph.addVertex("A");
      Vertex vertexB = graph.addVertex("B");
      Vertex vertexC = graph.addVertex("C");
      Vertex vertexD = graph.addVertex("D");
      Vertex vertexE = graph.addVertex("E");
      Vertex vertexF = graph.addVertex("F");
      Vertex[] vertices = { vertexA, vertexB, vertexC, vertexD, vertexE, vertexF };
      graph.addDirectedEdge(vertexA, vertexB, -600);
      graph.addDirectedEdge(vertexA, vertexC, 2);
      graph.addUndirectedEdge(vertexB, vertexC, 1);
      graph.addUndirectedEdge(vertexB, vertexD, 3);
      graph.addDirectedEdge(vertexB, vertexE, 2);
      graph.addUndirectedEdge(vertexC, vertexE, 2);
      graph.addDirectedEdge(vertexD, vertexC, 1);
      graph.addUndirectedEdge(vertexD, vertexE, 4);
      graph.addDirectedEdge(vertexD, vertexF, 3);
      graph.addDirectedEdge(vertexE, vertexF, 3);
      
      // Set starting vertex for shortest paths
      Vertex startVertex = vertexA;
      
      // Run Bellman-Ford's shortest path algorithm. Display results if
      // successful, or error message if a negative edge weight cycle exists.
      HashMap<Vertex, PathVertexInfo> result = bellmanFord(graph, startVertex);
      if (result != null) {
         for (Vertex vertex : vertices) {
            String path = getShortestPath(startVertex, vertex, result);
            System.out.printf("%s -> %s: %s (%d)%n", startVertex.label, 
               vertex.label, path, (int)result.get(vertex).distance);
         }
      }
      else {
         System.out.println("Bellman-Ford failed, negative edge weight cycle detected.");
      }
   }
}
