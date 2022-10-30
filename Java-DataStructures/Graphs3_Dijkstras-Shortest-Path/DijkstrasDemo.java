import java.lang.Comparable;
import java.util.HashMap;
import java.util.PriorityQueue;

// Stores information for a vertex that is relevant to a shortest path algorithm
class PathVertexInfo implements Comparable<PathVertexInfo> {
   public Vertex vertex;
   public double distance;
   public Vertex predecessor;
   
   public PathVertexInfo(Vertex vertex) {
      this.vertex = vertex;
      distance = Double.POSITIVE_INFINITY;
      predecessor = null;
   }
   
   public int compareTo(PathVertexInfo other) {
      if (distance > other.distance) {
         return 1;
      }
      else if (distance < other.distance) {
         return -1;
      }
      return 0;
   }
}

public class DijkstrasDemo {
   public static HashMap<Vertex, PathVertexInfo> dijkstraShortestPath(
      Graph graph, Vertex startVertex) {
      // Create the HashMap for vertex information
      HashMap<Vertex, PathVertexInfo> info;
      info = new HashMap<Vertex, PathVertexInfo>();

      // Put all graph vertices in both the info HashMap and the PriorityQueue 
      // of unvisited vertices
      PriorityQueue<PathVertexInfo> unvisited;
      unvisited = new PriorityQueue<PathVertexInfo>();
      for (Vertex vertex : graph.getVertices()) {
         PathVertexInfo vertexInfo = new PathVertexInfo(vertex);
         unvisited.add(vertexInfo);
         info.put(vertex, vertexInfo);
      }
      
      // startVertex has a distance of 0 from itself
      info.get(startVertex).distance = 0.0;
      
      // Iterate through all vertices in the priority queue
      while (unvisited.size() > 0) {
         // Get info about the vertex with the shortest distance from startVertex
         PathVertexInfo currentInfo = unvisited.peek();
         unvisited.remove();
         
         // Check potential path lengths from the current vertex to all neighbors
         for (Edge edge : graph.getEdgesFrom(currentInfo.vertex)) {
            Vertex adjacentVertex = edge.toVertex;
            double alternativePathDistance = currentInfo.distance + edge.weight;
            
            // If a shorter path from startVertex to adjacentVertex is found,
            // update adjacentVertex's distance and predecessor
            PathVertexInfo adjacentInfo = info.get(adjacentVertex);
            if (alternativePathDistance < adjacentInfo.distance) {
               unvisited.remove(adjacentInfo);
               adjacentInfo.distance = alternativePathDistance;
               adjacentInfo.predecessor = currentInfo.vertex;
               unvisited.add(adjacentInfo);
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
      Graph g = new Graph();

      Vertex vertexA = g.addVertex("A");
      Vertex vertexB = g.addVertex("B");
      Vertex vertexC = g.addVertex("C");
      Vertex vertexD = g.addVertex("D");
      Vertex vertexE = g.addVertex("E");
      Vertex vertexF = g.addVertex("F");
      Vertex vertexG = g.addVertex("G");
      Vertex[] vertices = { vertexA, vertexB, vertexC, vertexD, vertexE, vertexF, vertexG };

      g.addUndirectedEdge(vertexA, vertexB, 8);
      g.addUndirectedEdge(vertexA, vertexC, 7);
      g.addUndirectedEdge(vertexA, vertexD, 3);
      g.addUndirectedEdge(vertexB, vertexE, 6);
      g.addUndirectedEdge(vertexC, vertexD, 1);
      g.addUndirectedEdge(vertexC, vertexE, 2);
      g.addUndirectedEdge(vertexD, vertexF, 15);
      g.addUndirectedEdge(vertexD, vertexG, 12);
      g.addUndirectedEdge(vertexE, vertexF, 4);
      g.addUndirectedEdge(vertexF, vertexG, 1);

      // Run Dijkstra's algorithm first.
      HashMap<Vertex, PathVertexInfo> infoMap = dijkstraShortestPath(g, vertexA);

      // Display shortest path for each vertex from vertexA.    
      for (Vertex vertex : vertices) {
         PathVertexInfo info = infoMap.get(vertex);
         if (info.predecessor == null && vertex != vertexA) {
            System.out.printf("A to %s: no path exists%n", vertex.label);
         }
         else {
            System.out.printf("A to %s: %s (total weight: %d)%n", vertex.label, 
               getShortestPath(vertexA, vertex, infoMap), (int)info.distance);
         }
      }
   }
}
